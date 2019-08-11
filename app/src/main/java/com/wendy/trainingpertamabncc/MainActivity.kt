package com.wendy.trainingpertamabncc

import android.app.Activity
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.wendy.trainingpertamabncc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        private const val RESULT_REQUEST_CODE = 1
    }

    private val currentText = "This Is Main Activity"
    private lateinit var textView: TextView

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == RESULT_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                data?.let {
                    val result = it.getStringExtra(ResultActivity.RETURN_KEYWORD) ?: "No Data"
                    textView.text = result
                }
            } else {
                textView.text = "Sorry, No Data Available"
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val view = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        textView = view.textviewHello

        view.textviewHello.text = currentText
        view.btnNextActivity.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(ResultActivity.KEYWORD, view.editTextData.text.toString())
            startActivityForResult(intent, RESULT_REQUEST_CODE)
        }
    }
}
