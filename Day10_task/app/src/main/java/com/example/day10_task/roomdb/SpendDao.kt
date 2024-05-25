package com.example.day10_task.roomdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.day10_task.roomdb.Spend

@Dao
public interface SpendDao {
    @Query("SELECT * FROM spend_table")
    public fun getAllSpend(): List<Spend>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addSpend(spend: Spend)


}