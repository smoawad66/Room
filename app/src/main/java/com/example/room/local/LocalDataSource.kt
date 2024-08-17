package com.example.room.local
import com.example.room.models.Color

class LocalDataSource private constructor() : ILocalDataSource {

    companion object {
        @Volatile
        private var localDataSource: LocalDataSource? = null

        fun getInstance(): LocalDataSource {
            if (localDataSource == null)
                localDataSource = synchronized(this) { LocalDataSource() }

            return localDataSource as LocalDataSource
        }
    }

    override fun getAllColors() = MyRoomDatabase.getInstance().getColorDao().getAllColors()
    override suspend fun insertColor(color: Color) = MyRoomDatabase.getInstance().getColorDao().insertColor(color)
    override suspend fun deleteColor(color: Color) = MyRoomDatabase.getInstance().getColorDao().deleteColor(color)
}