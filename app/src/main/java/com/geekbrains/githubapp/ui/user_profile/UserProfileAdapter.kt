package com.geekbrains.githubapp.ui.user_profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geekbrains.githubapp.databinding.UserProfileItemBinding
import com.geekbrains.githubapp.domain.project.GitProject

class UserProfileAdapter : RecyclerView.Adapter<UserProfileAdapter.UserProfileViewHolder>() {

    private var data: List<GitProject> = emptyList()

    fun setData(projects: List<GitProject>) {
        data = projects
        notifyDataSetChanged()
    }

    inner class UserProfileViewHolder(
        private val binding: UserProfileItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: GitProject) {
            binding.repository.text = item.name
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserProfileViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return UserProfileViewHolder(UserProfileItemBinding.inflate(inflater))
    }

    override fun onBindViewHolder(holder: UserProfileViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private fun getItem(pos: Int): GitProject = data[pos]

    override fun getItemCount(): Int {
        return data.size
    }
}