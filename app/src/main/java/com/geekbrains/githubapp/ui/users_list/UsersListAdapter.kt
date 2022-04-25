package com.geekbrains.githubapp.ui.users_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geekbrains.githubapp.data.mock.MockUsersRepoImpl
import com.geekbrains.githubapp.databinding.UsersListItemBinding
import com.geekbrains.githubapp.domain.entity.User

class UsersListAdapter : RecyclerView.Adapter<UsersListAdapter.UsersListViewHolder>() {

    private val usersList: List<User> = MockUsersRepoImpl().getUsersList()
    var listener: OnItemClick? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UsersListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return UsersListViewHolder(UsersListItemBinding.inflate(inflater))
    }

    override fun onBindViewHolder(holder: UsersListViewHolder, position: Int) {
        holder.bind(usersList[position])
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    fun interface OnItemClick {
        fun onClick(user: User)
    }

    inner class UsersListViewHolder(
        private val binding: UsersListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            itemView.apply {
                binding.userNameItemTextView.text = user.userName
                setOnClickListener {
                    listener?.onClick(user)
                }
            }
        }
    }
}