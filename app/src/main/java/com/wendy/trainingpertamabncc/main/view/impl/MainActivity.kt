package com.wendy.trainingpertamabncc.main.view.impl

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.EditText
import android.widget.Toast
import com.wendy.trainingpertamabncc.R
import com.wendy.trainingpertamabncc.databinding.ActivityMainBinding
import com.wendy.trainingpertamabncc.main.presenter.contract.MainPresenter
import com.wendy.trainingpertamabncc.main.presenter.impl.MainPresenterImpl
import com.wendy.trainingpertamabncc.main.view.contract.MainView
import com.wendy.trainingpertamabncc.main.view.impl.adapter.MainUserAdapter

class MainActivity : AppCompatActivity(), MainView {

    private var presenter: MainPresenter? = null
    private var mainUserAdapter: MainUserAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        presenter = MainPresenterImpl(this)

        view.btnNextActivity.setOnClickListener {
            presenter?.addUserData(view.editTextData.text.toString())
        }

        mainUserAdapter = MainUserAdapter(presenter?.getAllItems() as MutableList<String>) {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
        view.rvUser.layoutManager = LinearLayoutManager(this)
        view.rvUser.adapter = mainUserAdapter
    }

    override fun populateList(lists: MutableList<String>) {
        mainUserAdapter?.submitLists(lists)
    }
}
