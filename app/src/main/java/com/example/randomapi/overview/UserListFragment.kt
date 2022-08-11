package com.example.randomapi.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.randomapi.databinding.UserListFragmentBinding

class UserListFragment : Fragment(), UserClickListener {

    private val viewModel by activityViewModels<UserViewModel>()
    private lateinit var binding: UserListFragmentBinding
    private lateinit var adapter: UserItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = UserListFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = UserItemAdapter(this)
        binding.userRecyclerView.adapter = adapter
        viewModel.users.observe(viewLifecycleOwner) {
            adapter.userList = it
        }
    }

    override fun onItemClick(position: Int) {
        TODO("Not yet implemented")
    }


}