/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.codelabs.paging.ui

import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.*
import androidx.lifecycle.map
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import com.example.android.codelabs.paging.Injection
import com.example.android.codelabs.paging.databinding.ActivitySearchRepositoriesBinding
import com.example.android.codelabs.paging.model.Repo
import com.example.android.codelabs.paging.model.RepoSearchResult
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class SearchRepositoriesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySearchRepositoriesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // get the view model
        val viewModel = ViewModelProvider(
            this, Injection.provideViewModelFactory(
                context = this,
                owner = this
            )
        )
            .get(SearchRepositoriesViewModel::class.java)


        // add dividers between RecyclerView's row items
        val decoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        binding.list.addItemDecoration(decoration)

        // bind the state
        binding.bindState(
            uiState = viewModel.state,
            pagingData = viewModel.pagingDataFlow,
            uiActions = viewModel.accept
        )
    }


    private fun ActivitySearchRepositoriesBinding.bindState(
        uiState: StateFlow<UiState>,
        pagingData: Flow<PagingData<UiModel>>,
        uiActions: (UiAction) -> Unit
    ) {
        val repoAdapter = ReposAdapter()
        list.adapter = repoAdapter.withLoadStateHeaderAndFooter(
            header = ReposLoadStateAdapter { repoAdapter.retry() },
            footer = ReposLoadStateAdapter { repoAdapter.retry() }
        )


        bindSearch(
            uiState = uiState,
            onQueryChanged = uiActions
        )
        bindList(
            repoAdapter = repoAdapter,
            uiState = uiState,
            pagingData = pagingData,
            onScrollChanged = uiActions
        )
    }

    private fun ActivitySearchRepositoriesBinding.bindSearch(
        uiState: StateFlow<UiState>,
        onQueryChanged: (UiAction.Search) -> Unit
    ) {
        searchRepo.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_GO) {
                updateRepoListFromInput(onQueryChanged)
                true
            } else {
                false
            }
        }
        searchRepo.setOnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                updateRepoListFromInput(onQueryChanged)
                true
            } else {
                false
            }
        }

        lifecycleScope.launch {
            uiState
                .map { it.query }
                .distinctUntilChanged()
                .collect(searchRepo::setText)
        }
    }

    private fun ActivitySearchRepositoriesBinding.updateRepoListFromInput(onQueryChanged: (UiAction.Search) -> Unit) {
        searchRepo.text.trim().let {
            if (it.isNotEmpty()) {
                list.scrollToPosition(0)
                onQueryChanged(UiAction.Search(query = it.toString()))
            }
        }
    }

    private fun ActivitySearchRepositoriesBinding.bindList(
        repoAdapter: ReposAdapter,
        uiState: StateFlow<UiState>,
        pagingData: Flow<PagingData<UiModel>>,
        onScrollChanged: (UiAction.Scroll) -> Unit
    ) {

        retryButton.setOnClickListener { repoAdapter.retry() }


        list.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy != 0) onScrollChanged(UiAction.Scroll(currentQuery = uiState.value.query))
            }
        })
        val notLoading = repoAdapter.loadStateFlow
            // Only emit when REFRESH LoadState for the paging source changes.
            .distinctUntilChangedBy { it.source.refresh }
            // Only react to cases where REFRESH completes i.e., NotLoading.
            .map { it.source.refresh is LoadState.NotLoading }

        val hasNotScrolledForCurrentSearch = uiState
            .map { it.hasNotScrolledForCurrentSearch }
            .distinctUntilChanged()

        val shouldScrollToTop = combine(
            notLoading,
            hasNotScrolledForCurrentSearch,
            Boolean::and
        )
            .distinctUntilChanged()

        lifecycleScope.launch {
            repoAdapter.loadStateFlow.collect { loadState ->
                val isListEmpty = loadState.refresh is LoadState.NotLoading && repoAdapter.itemCount == 0
                // show empty list
                emptyList.isVisible = isListEmpty
                // Only show the list if refresh succeeds.
                list.isVisible = !isListEmpty
                // Show loading spinner during initial load or refresh.
                progressBar.isVisible = loadState.source.refresh is LoadState.Loading
                // Show the retry state if initial load or refresh fails.
                retryButton.isVisible = loadState.source.refresh is LoadState.Error

                // Toast on any error, regardless of whether it came from RemoteMediator or PagingSource
                val errorState = loadState.source.append as? LoadState.Error
                    ?: loadState.source.prepend as? LoadState.Error
                    ?: loadState.append as? LoadState.Error
                    ?: loadState.prepend as? LoadState.Error
                errorState?.let {
                    Toast.makeText(
                        this@SearchRepositoriesActivity,
                        "\uD83D\uDE28 Wooops ${it.error}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

        lifecycleScope.launch {
            pagingData.collectLatest(repoAdapter::submitData)
        }

        lifecycleScope.launch {
            shouldScrollToTop.collect { shouldScroll ->
                if (shouldScroll) list.scrollToPosition(0)
            }
        }
    }
}
