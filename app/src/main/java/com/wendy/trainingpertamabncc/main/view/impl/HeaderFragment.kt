package com.wendy.trainingpertamabncc.main.view.impl

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wendy.trainingpertamabncc.R
import com.wendy.trainingpertamabncc.databinding.FragmentHeaderBinding

class HeaderFragment : Fragment() {

    private lateinit var binding: FragmentHeaderBinding
    private var title: String? = null

    companion object {
        private const val HEADER_FRAGMENT_TITLE = "HEADER_FRAGMENT_TITLE"
        fun getInstance(title: String): HeaderFragment {
            val headerFragment = HeaderFragment()
            val bundle = Bundle()
            bundle.putString(HEADER_FRAGMENT_TITLE, title)
            headerFragment.arguments = bundle
            return headerFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = arguments?.getString(HEADER_FRAGMENT_TITLE) ?: "Default Header"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_header, container, false)
        binding.headerTitle.apply {
            text = title
            setOnClickListener {
                //                val intent = Intent(activity, ResultActivity::class.java)
//                startActivity(intent)
                val parentActivity = activity as MainActivity
                parentActivity.showToast()
            }
        }
        return binding.root
    }
}