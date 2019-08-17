package com.wendy.trainingpertamabncc.main.presenter.impl

import com.wendy.trainingpertamabncc.main.presenter.contract.MainPresenter
import com.wendy.trainingpertamabncc.main.view.contract.MainView

class MainPresenterImpl(private var view: MainView) : MainPresenter {

    private val items = mutableListOf("A", "B", "C", "D", "E")

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
}