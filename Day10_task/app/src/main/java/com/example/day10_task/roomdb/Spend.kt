package com.example.day10_task.roomdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "spend_table")
data class Spend(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "NgayTao") val ngaytao: String,
    @ColumnInfo("GhiChu") val ghichu: String,
    @ColumnInfo("TienChi") val tienchi: Int,
    @ColumnInfo("DanhMuc") val danhmuc: String
)