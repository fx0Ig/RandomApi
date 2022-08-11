package com.example.randomapi.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.randomapi.databinding.UserItemBinding
import com.example.randomapi.domain.User

class UserItemAdapter(private val listener: UserClickListener) :
    RecyclerView.Adapter<UserItemAdapter.UserItemHolder>() {

    var userList: List<User> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemAdapter.UserItemHolder {
        return UserItemHolder.create(parent, listener)
    }

    override fun onBindViewHolder(holder: UserItemAdapter.UserItemHolder, position: Int) {
        holder.bind(userList[position], position)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class UserItemHolder private constructor(
        private val binding: UserItemBinding,
        private val listener: UserClickListener
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: User, position: Int) {
            binding.userName.text = item.name
            binding.userName.setOnClickListener {
                listener.onItemClick(position)
            }
        }

        companion object {

            fun create(parent: ViewGroup, listener: UserClickListener): UserItemHolder = UserItemHolder(
                UserItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ), listener
            )

        }


    }

}

interface UserClickListener {

    fun onItemClick(position: Int)
}