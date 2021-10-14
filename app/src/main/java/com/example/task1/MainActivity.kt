package com.example.task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task1.Adapter.PostAdapter
import com.example.task1.Model.Post
import com.example.task1.ViewModel.PostViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter:PostAdapter
    private lateinit var postViewModel: PostViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUi()
        postViewModel=ViewModelProvider(this)[PostViewModel::class.java]
        postViewModel.getPost()
        postViewModel.responseLiveData.observe(this, Observer {
            postAdapter.setPostData(it as ArrayList<Post>)
            progressBar.visibility=View.GONE
            recyclerView.visibility=View.VISIBLE
        })
    }

    private fun initUi(){
        recyclerView=findViewById(R.id.recyclerView)
        postAdapter=PostAdapter(this, ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager=LinearLayoutManager(this@MainActivity)
            adapter=postAdapter
        }
    }
}