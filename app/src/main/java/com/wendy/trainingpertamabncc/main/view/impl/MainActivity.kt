package com.wendy.trainingpertamabncc.main.view.impl

import android.content.Context
import android.content.SharedPreferences
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
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
    private var sharedPreference: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        presenter = MainPresenterImpl(this)

        sharedPreference = getSharedPreferences("Training_BNCC_Pertama", Context.MODE_PRIVATE)

        val userName = sharedPreference?.getString("userName", "")

        userName?.let {
            if (it.isBlank()) {
                Toast.makeText(this, "NO Username", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Your Username : $it", Toast.LENGTH_LONG).show()
            }
        }

        view.btnNextActivity.setOnClickListener {
            val user = view.editTextData.text.toString()
            if (user.isBlank()) {
                Toast.makeText(this, "Data Cannot Be Blank", Toast.LENGTH_LONG).show()
            } else {
                presenter?.addUserData(user)
            }
        }

        mainUserAdapter = MainUserAdapter(presenter?.getAllItems() as MutableList<String>) { name ->
            presenter?.deleteUser(name)
        }

        supportFragmentManager.beginTransaction()
            .replace(
                view.mainFrameLayout.id, HeaderFragment.getInstance("WOI")
            ).commit()

        view.rvUser.layoutManager = LinearLayoutManager(this)
        view.rvUser.adapter = mainUserAdapter
    }

    fun showToast() {
        sharedPreference?.edit()?.putString("userName", "Wendy Yanto")?.apply()
        Toast.makeText(this, "Data From Fragment", Toast.LENGTH_LONG).show()
        presenter?.getPostId(1)
    }

    override fun populateList(lists: MutableList<String>) {
        mainUserAdapter?.submitLists(lists)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.finish()
        presenter = null
    }
}
