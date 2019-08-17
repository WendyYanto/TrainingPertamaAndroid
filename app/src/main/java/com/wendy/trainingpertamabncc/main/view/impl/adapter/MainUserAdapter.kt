package com.wendy.trainingpertamabncc.main.view.impl.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.wendy.trainingpertamabncc.R

class MainUserAdapter(
    private var items: MutableList<String>,
    private val listener: (index: String) -> Unit
) :
    RecyclerView.
    Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.items_user_main, viewGroup, false)
        return UserViewHolder(view, listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitLists(newItems: MutableList<String>) {
        this.items = newItems
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, index: Int) {
        val view = viewHolder as UserViewHolder
        view.bind(items[index])
    }

    inner class UserViewHolder(
        private val view: View,
        private val listener: (index: String) -> Unit
    ) : RecyclerView.ViewHolder(view) {

        private var textView: TextView? = null

        fun bind(data: String) {
            textView = view.findViewById(R.id.tv_user_name)
            textView?.text = data
            textView?.setOnClickListener {
                listener.invoke(data)
            }
        }
    }
}