package com.example.room.repo

import com.example.room.local.LocalDataSource
import com.example.room.models.Color

class Repo(private val localDataSource: LocalDataSource): IRepo {
    override fun getAllColors() = localDataSource.getAllColors()
    override suspend fun insertColor(color: Color) = localDataSource.insertColor(color)
    override suspend fun deleteColor(color: Color) = localDataSource.deleteColor(color)
}