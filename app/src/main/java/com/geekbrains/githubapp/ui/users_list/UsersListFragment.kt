package com.geekbrains.githubapp.ui.users_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.geekbrains.githubapp.R
import com.geekbrains.githubapp.databinding.FragmentUsersListBinding
import com.geekbrains.githubapp.ui.user_profile.UserProfileFragment

class UsersListFragment : Fragment() {

    private lateinit var viewModel: UsersListViewModel
    private val adapter = UsersListAdapter()

    private var _binding: FragmentUsersListBinding? = null
    private val binding: FragmentUsersListBinding
        get() = _binding!!

    companion object {
        fun newInstance() = UsersListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_users_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentUsersListBinding.bind(view)

        initUsersList()

        adapter.listener = UsersListAdapter.OnItemClick { user ->
            val bundle = Bundle()
            bundle.putString("NAME", user.userName)

            requireActivity().supportFragmentManager
                .beginTransaction()
                .addToBackStack("")
                .replace(R.id.main_container_layout, UserProfileFragment.newInstance(bundle))
                .commit()
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