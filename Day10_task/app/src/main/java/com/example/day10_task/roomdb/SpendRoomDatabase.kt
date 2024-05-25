package com.example.day10_task.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.day10_task.Converters
import com.example.day10_task.fragment.ThuFragment

@Database(entities = [Spend::class], version = 3, exportSchema = false)
@TypeConverters(Converters::class)
abstract class SpendRoomDatabase() : RoomDatabase() {
    abstract fun spendDao(): SpendDao

    companion object {
        @Volatile
        private var INSTANCE: SpendRoomDatabase? = null

        fun getDatabase(context: Context): SpendRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SpendRoomDatabase::class.java,
                    "spend_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}