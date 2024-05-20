package com.example.day10_task

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SpendDao {
    @Query("SELECT * FROM spend_table")
    fun getAllSpend(): List<Spend>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addSpend(spend: Spend)
}