package com.geekbrains.githubapp.ui.user_profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.geekbrains.githubapp.R
import com.geekbrains.githubapp.databinding.FragmentUserProfileBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserProfileFragment : Fragment() {
    private val adapter = UserProfileAdapter()

    private var _binding: FragmentUserProfileBinding? = null
    private val binding: FragmentUserProfileBinding
        get() = _binding!!

    companion object {
        fun newInstance(bundle: Bundle): UserProfileFragment {
            val fragment = UserProfileFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentUserProfileBinding.bind(view)
        initProfile()
    }

    private fun initProfile() {
        binding.userProfileRecyclerView.adapter = adapter

        val userName = arguments?.getString("NAME").toString()
        binding.userNameTextView.text = userName

        val viewModel: UserProfileViewModel by viewModel()

        viewModel.apply {
            getProjects(userName)
            getAvatar(userName)
            projects.observe(viewLifecycleOwner) {
                adapter.setData(it)
            }

            avatar.observe(viewLifecycleOwner){
                binding.avatarImageView.load(it.avatar_url)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

