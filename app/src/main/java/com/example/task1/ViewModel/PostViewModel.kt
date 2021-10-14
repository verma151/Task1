package com.example.task1.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task1.Model.Post
import com.example.task1.Repository.PostRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    val responseLiveData:MutableLiveData<List<Post>> = MutableLiveData()

    fun  getPost()
    {
        viewModelScope.launch {
            PostRepository.getPost()
                .catch { e->
                    Log.d("main","getPost: ${e.message}")
                }
                .collect { response->
                    responseLiveData.value=response

                }
        }
    }

}