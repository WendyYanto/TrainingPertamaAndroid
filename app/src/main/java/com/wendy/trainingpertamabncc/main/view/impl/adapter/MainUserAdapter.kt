package com.wendy.trainingpertamabncc.main.view.impl.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.wendy.trainingpertamabncc.databinding.ItemsUserMainBinding

class MainUserAdapter(
    private var items: MutableList<String>,
    private val listener: (index: String) -> Unit
) :
    RecyclerView.
    Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        val binding = ItemsUserMainBinding.inflate(layoutInflater, viewGroup, false)
        return UserViewHolder(binding, listener)
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
        private val binding: ItemsUserMainBinding,
        private val listener: (index: String) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: String) {
            binding.executePendingBindings()
            binding.tvUserName.apply {
                text = data
                setOnClickListener {
                    listener.invoke(data)
                }
            }
        }
    }
}