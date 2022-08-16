package com.example.helloworld.post.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.helloworld.post.model.postmodel.JsonPostsItem
import com.example.helloworld.network.PostApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class PostViewModel : ViewModel() {

    private val postService = PostApiService()
    private val disposable = CompositeDisposable()
    val post = MutableLiveData<List<JsonPostsItem>>()

    fun refresh() {
        fetchFromRemote()
    }

    private fun fetchFromRemote() {
        disposable.add(
            postService.getPost()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<JsonPostsItem>>() {
                    override fun onSuccess(postList: List<JsonPostsItem>) {
                        post.value = postList
                    }
                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}