package com.example.room.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.room.models.Color

@Dao
interface ColorDao {

    @Query("SELECT * FROM colors")
    fun getAllColors(): LiveData<List<Color>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertColor(color: Color)

    @Delete
    suspend fun deleteColor(color: Color)

}