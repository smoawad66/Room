package com.example.room.ui.viewModel

import ColorViewModelFactory
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.room.local.LocalDataSource
import com.example.room.models.Color
import com.example.room.repo.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ColorViewModel(private val repo: Repo) : ViewModel() {

    val colors: LiveData<List<Color>> = repo.getAllColors()

    suspend fun insertColor(color: Color) = repo.insertColor(color)
    suspend fun deleteColor(color: Color) = repo.deleteColor(color)
}