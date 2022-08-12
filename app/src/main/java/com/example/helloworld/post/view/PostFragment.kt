package com.example.helloworld.post.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.helloworld.databinding.FragmentPostBinding
import com.example.helloworld.post.adapter.PostAdapter
import com.example.helloworld.post.model.JsonPosts
import com.example.helloworld.post.viewmodel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PostFragment : Fragment() {

    private val viewModel: PostViewModel by viewModels()

    // if something goes wrong it is here
    private lateinit var postAdapter: PostAdapter
    private lateinit var viewBinder: FragmentPostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinder = FragmentPostBinding.inflate(layoutInflater)
        postAdapter = PostAdapter(JsonPosts())

        fetchData()
        initView()
        observeLiveData()
        return viewBinder.root
    }

    private fun initView() {
        viewBinder.rvPost.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = postAdapter
        }
    }

    private fun observeLiveData() {
        viewModel.post.observe(viewLifecycleOwner, Observer {
            it?.let {
                postAdapter.updatePosts(it)
            }
        })
    }

    private fun fetchData() {
        viewModel.refresh()
    }

}