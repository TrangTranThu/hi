package com.example.day9

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface APIService {
    @GET("student")
    fun getAllStudents(): Call<List<Note>>

    @GET("student/{id}")
    fun getStudentById(@Path("id") id: String): Call<Note>

    @POST("student")
    fun createStudent(@Body note: Note): Call<Note>
}