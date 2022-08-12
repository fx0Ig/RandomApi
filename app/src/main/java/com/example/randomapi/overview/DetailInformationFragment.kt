package com.example.randomapi.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.randomapi.R
import com.example.randomapi.databinding.DetailInformationFragmentBinding

class DetailInformationFragment : Fragment() {

    private val viewModel by activityViewModels<UserViewModel>()
    private lateinit var binding: DetailInformationFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DetailInformationFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.selectedUser.observe(viewLifecycleOwner) {
            with(binding) {
                Glide.with(binding.root).load(it.picture).diskCacheStrategy(DiskCacheStrategy.ALL)
                    .error(R.drawable.image_broken)
                    .fallback(R.drawable.image_loading)
                    .into(userPicture)
                userName.text = it.name
                userSurname.text = it.surname
                userAddress.text = it.address
                userDob.text = it.dateOfBirth

            }
        }
    }

}