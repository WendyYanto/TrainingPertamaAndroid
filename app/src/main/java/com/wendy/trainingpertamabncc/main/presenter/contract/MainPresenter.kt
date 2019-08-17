package com.wendy.trainingpertamabncc.main.presenter.contract

interface MainPresenter {
    fun addUserData(name: String)
    fun getAllItems(): List<String>
}