package com.bignerdranch.android.myapplicationoncleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.myapplicationoncleanarchitecture.R

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.shoplist.observe(this) {
            Log.d("MainActiviteTest", it.toString())
        }
        viewModel.getShopList()
    }
}