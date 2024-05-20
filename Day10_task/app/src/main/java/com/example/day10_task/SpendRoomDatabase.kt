package com.example.day10_task

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Spend::class], version = 2, exportSchema = false)
abstract class SpendRoomDatabase : RoomDatabase() {
    abstract fun spendDao(): SpendDao

    companion object {
        @Volatile
        private var INSTANCE: SpendRoomDatabase? = null

        fun getDatabase(context: ThuFragment): SpendRoomDatabase {
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