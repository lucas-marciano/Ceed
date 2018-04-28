package com.lucasmarciano.ceep.retrofit

import com.lucasmarciano.ceep.retrofit.services.PostService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by lucasmarciano on 27/04/2018.
 * Nonus
 */
class RetrofitInitializer {

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    //Single-Expression function
//    fun postService(): NoteService = retrofit.create(NoteService::class.java)
    fun postService() = retrofit.create(PostService::class.java)
}