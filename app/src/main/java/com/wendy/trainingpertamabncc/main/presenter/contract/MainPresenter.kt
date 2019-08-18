package com.wendy.trainingpertamabncc.main.presenter.contract

interface MainPresenter {
    fun addUserData(name: String)
    fun getAllItems(): List<String>
    fun deleteUser(name: String)
    fun getPostId(id: Int)
    fun finish()
}