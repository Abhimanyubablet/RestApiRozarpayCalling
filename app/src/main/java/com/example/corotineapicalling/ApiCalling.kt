package com.example.corotineapicalling

import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.HeaderMap

interface ApiCalling {
    @GET("customers")
    fun getUser(@HeaderMap header: Map<String,String>): Observable<UserDataModel>
//    fun getUser(): Observable<List<DataModel>>
    companion object Factory {
        fun create(): ApiCalling {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.razorpay.com/v1/")
                .build()
            return retrofit.create(ApiCalling::class.java)
        }
    }
}