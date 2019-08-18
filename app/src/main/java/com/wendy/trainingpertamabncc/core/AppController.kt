package com.wendy.trainingpertamabncc.core

import com.wendy.trainingpertamabncc.core.service.PostService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppController {

    private var postService: PostService? = null

    private fun getRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun providePostService(): PostService {
        postService?.let {
            return it
        } ?: run {
            val postServiceRetrofit =
                this.getRetrofit("https://jsonplaceholder.typicode.com/").create(PostService::class.java)
            postService = postServiceRetrofit
            return postServiceRetrofit
        }
    }
}