package com.example.day7

import java.util.Date

data class Note(
    val title: String,
    val content: String,
    val createdAt: Date,
    val isFavorite: Boolean,
)
