package com.wendy.trainingpertamabncc.main.presenter.impl

import android.util.Log
import com.wendy.trainingpertamabncc.core.AppController
import com.wendy.trainingpertamabncc.main.model.PostResponse
import com.wendy.trainingpertamabncc.main.presenter.contract.MainPresenter
import com.wendy.trainingpertamabncc.main.view.contract.MainView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenterImpl(private var view: MainView) : MainPresenter {

    private val items = mutableListOf("A", "B", "C", "D", "E")
    private var postCall: Call<PostResponse>? = null

    override fun addUserData(name: String) {
        items.add(name)
        view.populateList(items)
    }

    override fun getAllItems(): List<String> {
        return this.items
    }

    override fun deleteUser(name: String) {
        items.remove(name)
        view.populateList(items)
    }

    override fun getPostId(id: Int) {
        postCall = AppController.providePostService().getPostById(id)
        postCall?.enqueue(object : Callback<PostResponse> {
            override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                Log.v("Error Retrofit", t.message)
            }

            override fun onResponse(call: Call<PostResponse>, response: Response<PostResponse>) {
                Log.v("Retrofit Response", response.body().toString())
            }
        })
    }

    override fun finish() {
        postCall?.cancel()
    }
}