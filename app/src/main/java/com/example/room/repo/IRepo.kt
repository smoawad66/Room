package com.example.room.repo
import androidx.lifecycle.LiveData
import com.example.room.models.Color
import kotlinx.coroutines.flow.Flow

interface IRepo {
    fun getAllColors(): LiveData<List<Color>>
    suspend fun insertColor(color: Color)
    suspend fun deleteColor(color: Color)
}