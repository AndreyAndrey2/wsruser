package com.example.wsruserfood.ui.foods

import android.view.LayoutInflater
import com.example.wsruserfood.ui.core.BaseFragment
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.wsruserfood.R
import com.example.wsruserfood.databinding.FragmentDrinksBinding
import com.example.wsruserfood.databinding.FragmentOneitemBinding
import com.example.wsruserfood.viewmodel.main.MainViewModel

class OneitemFragment: BaseFragment<MainViewModel, FragmentOneitemBinding>() {

    override val viewModel: MainViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentOneitemBinding =
        FragmentOneitemBinding.inflate(inflater, container, false)

    override fun setupViews() {
        mainActivity.hideBottomMenu()
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            requireActivity().finish()
            mainActivity.showBottomMenu()
        }
        with(binding){
            backBig.setOnClickListener{
                findNavController().navigate(R.id.action_oneitemFragment_to_mainFragment)
            }
        }
    }
}