package com.lucasmarciano.ceep.retrofit.services

import com.lucasmarciano.ceep.model.Post
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by lucasmarciano on 27/04/2018.
 * Nonus
 */
interface PostService {

    @GET("posts")
    fun list(): Call<List<Post>>
}