package com.example.task1.Network

import com.example.task1.Model.Post
import retrofit2.http.GET

interface ApiServices {
    //because posts page have the content
    @GET("comments")
    suspend fun getPost():List<Post>
}