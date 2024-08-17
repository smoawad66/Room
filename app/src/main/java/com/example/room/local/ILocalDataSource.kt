package com.example.room.local
import androidx.lifecycle.LiveData
import com.example.room.models.Color

interface ILocalDataSource {
    fun getAllColors(): LiveData<List<Color>>
    suspend fun insertColor(color: Color)
    suspend fun deleteColor(color: Color)
}