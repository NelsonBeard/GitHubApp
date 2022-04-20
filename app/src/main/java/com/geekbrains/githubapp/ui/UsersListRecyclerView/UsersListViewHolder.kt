package com.geekbrains.githubapp.ui.UsersListRecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geekbrains.githubapp.databinding.UsersListItemBinding
import com.geekbrains.githubapp.domain.User

class UsersListViewHolder(private val binding: UsersListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(parent: ViewGroup): UsersListViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            return UsersListViewHolder(UsersListItemBinding.inflate(inflater))
        }
    }

    fun bind(item: User) {
        binding.userName.text = item.name
    }
}