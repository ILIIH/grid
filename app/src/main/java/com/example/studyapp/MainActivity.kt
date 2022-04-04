package com.example.studyapp

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.studyapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Illia Branchuk")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName
    }

    fun clickHandlerFunction(view: View) {
        binding.apply {

            myName.nickname = editTextTextPersonName.text.toString()
            editTextTextPersonName.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE

            invalidateAll()

        }

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun updateNickname(view: View) {

        binding.apply {
            editTextTextPersonName.visibility = View.VISIBLE
            done.visibility = View.VISIBLE
            view.visibility = View.GONE
            editTextTextPersonName.requestFocus()

            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(editTextTextPersonName, 0)
        }


    }


}