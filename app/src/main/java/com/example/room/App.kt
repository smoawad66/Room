package com.example.room

import ColorViewModelFactory
import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import com.example.room.local.LocalDataSource
import com.example.room.local.MyRoomDatabase
import com.example.room.repo.Repo
import com.example.room.ui.viewModel.ColorViewModel

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        MyRoomDatabase.initRoom(applicationContext)
    }

    companion object {
        @Volatile
        private var colorViewModel: ColorViewModel? = null

        fun getColorViewModel(owner: ViewModelStoreOwner): ColorViewModel {
            if (colorViewModel == null) {
                synchronized(this) {
                    val repo = Repo(LocalDataSource.getInstance())
                    val factory = ColorViewModelFactory(repo)
                    colorViewModel = ViewModelProvider(owner, factory)[ColorViewModel::class.java]
                }
            }
            return colorViewModel as ColorViewModel
        }
    }

}