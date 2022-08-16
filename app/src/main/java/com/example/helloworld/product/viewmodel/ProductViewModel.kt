package com.example.helloworld.product.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.helloworld.product.model.Product
import com.example.helloworld.product.model.Products
import com.example.helloworld.product.retrofit.ProductApiService
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductViewModel : ViewModel() {

    private val productService = ProductApiService()
    private val disposable   = CompositeDisposable()
    val products = MutableLiveData<List<Product>>()

    fun fetchData(){
        //fromRemoteData()
        fromRemoteData1()
    }

    private fun fromRemoteData1() {
   productService.getProducts().enqueue(object : Callback<Products>{
       override fun onResponse(call: Call<Products>, response: Response<Products>) {
           products.value = response.body()?.products

       }

       override fun onFailure(call: Call<Products>, t: Throwable) {
Log.i("TAG_ERROR",t.message.toString())
       }


   })

    }

//    private fun fromRemoteData() {
//
//        disposable.add(
//            productService.getProduct()
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(object : DisposableSingleObserver<List<Product>>(){
//
//                    override fun onSuccess(value: List<Product>) {
//                        products.value = value
//
//                        Log.i("PViewModel",value.toString())
//
//                    }
//
//                    override fun onError(e: Throwable) {
//                        e.printStackTrace()
//
//                        Log.i("PViewModelError",e.message.toString())
//e                    }
//
//                })
//        )
//
//    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}