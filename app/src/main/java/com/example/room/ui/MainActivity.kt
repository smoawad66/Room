package com.example.room.ui

import ColorViewModelFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.room.R
import com.example.room.local.LocalDataSource
import com.example.room.repo.Repo
import com.example.room.ui.viewModel.ColorViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var colorViewModel: ColorViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setSupportActionBar(findViewById(R.id.toolbar))
    }
}