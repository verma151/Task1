package com.example.task1.Repository

import com.example.task1.Model.Post
import com.example.task1.Network.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PostRepository {

    companion object{
        fun getPost():Flow<List<Post>> = flow {
            val response=RetrofitBuilder.api.getPost()
            emit(response)
        }.flowOn(Dispatchers.IO)
    }
}