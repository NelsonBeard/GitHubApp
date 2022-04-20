package com.geekbrains.githubapp.ui.UsersListRecyclerView

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geekbrains.githubapp.data.MockUsersRepoImpl
import com.geekbrains.githubapp.domain.User

class UsersListAdapter : RecyclerView.Adapter<UsersListViewHolder>() {
    private val usersList: List<User> = MockUsersRepoImpl().getUsersList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersListViewHolder {
        return UsersListViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: UsersListViewHolder, position: Int) {
        holder.bind(usersList[position])
    }

    override fun getItemCount(): Int {
        return usersList.size
    }
}