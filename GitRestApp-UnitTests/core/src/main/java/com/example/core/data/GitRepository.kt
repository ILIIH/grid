package com.example.core.data

import androidx.paging.PagingData
import com.example.core.domain.Repo
import io.reactivex.Flowable

interface GitRepository {
    fun getRepository(UserName: String): Flowable<PagingData<Repo>>
    fun autentificate(token: String, login: String)
}
