package com.example.room.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.room.models.Color

@Database(entities = [Color::class], version = 1, exportSchema = false)
abstract class MyRoomDatabase : RoomDatabase() {

    abstract fun getColorDao(): ColorDao

    companion object {
        @Volatile
        private var INSTANCE: MyRoomDatabase? = null

        fun initRoom(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = synchronized(this) {
                    Room.databaseBuilder(
                        context.applicationContext,
                        MyRoomDatabase::class.java,
                        "color_db"
                    ).build()
                }
            }

        }

        fun getInstance() = INSTANCE as MyRoomDatabase
    }

}