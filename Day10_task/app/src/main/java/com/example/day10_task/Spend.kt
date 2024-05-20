package com.example.day10_task

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "spend_table")
data class Spend(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "NgayTao") val ngaytao: Long,
    @ColumnInfo("GhiChu") val ghichu: String,
    @ColumnInfo("TienChi") val tienchi: Int,
    @ColumnInfo("DanhMuc") val danhmuc: Boolean
)