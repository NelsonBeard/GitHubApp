package com.geekbrains.githubapp.ui.users_list

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.geekbrains.githubapp.R
import com.geekbrains.githubapp.databinding.UsersListFragmentBinding
import com.geekbrains.githubapp.ui.user_profile.UserProfileActivity

class UsersListFragment : Fragment() {

    private lateinit var viewModel: UsersListViewModel
    private val adapter = UsersListAdapter()

    private var _binding: UsersListFragmentBinding? = null
    private val binding: UsersListFragmentBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.users_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = UsersListFragmentBinding.bind(view)

        initUsersList()

        adapter.listener = UsersListAdapter.OnItemClick { user ->
            val intent = Intent(context, UserProfileActivity::class.java)
            intent.putExtra("NAME", user.userName)
            startActivity(intent)
        }
    }

    private fun initUsersList() {
        viewModel = ViewModelProvider(this)[UsersListViewModel::class.java]
        viewModel.getData().observe(viewLifecycleOwner) {
            binding.usersListRecyclerView.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}