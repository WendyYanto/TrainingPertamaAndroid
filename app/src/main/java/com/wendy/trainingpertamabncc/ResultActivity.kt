package com.wendy.trainingpertamabncc

import android.app.Activity
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.wendy.trainingpertamabncc.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    companion object {
        const val KEYWORD = "KEYWORD"
        const val RETURN_KEYWORD = "RETURN_KEYWORD"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = DataBindingUtil.setContentView<ActivityResultBinding>(this, R.layout.activity_result)
        val keyword = intent.getStringExtra(KEYWORD)

        if (keyword.isNullOrBlank()) {
            view.textviewResult.text = "No Data From Main"
        } else {
            view.textviewResult.text = keyword
        }

        view.buttonResult.setOnClickListener {
            val intent = Intent()
            intent.putExtra(RETURN_KEYWORD, "Hallo From Result Activity")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
