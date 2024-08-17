package com.example.room.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "colors")
data class Color(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val hex: String,
) : Serializable
