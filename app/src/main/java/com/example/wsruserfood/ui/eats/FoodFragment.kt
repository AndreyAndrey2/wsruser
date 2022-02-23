package com.example.wsruserfood.ui.eats

import android.view.LayoutInflater
import com.example.wsruserfood.ui.core.BaseFragment
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.viewModels
import com.example.wsruserfood.databinding.FragmentFoodBinding
import com.example.wsruserfood.databinding.FragmentHistoryBinding
import com.example.wsruserfood.viewmodel.main.MainViewModel

class FoodFragment: BaseFragment<MainViewModel, FragmentFoodBinding>() {

    override val viewModel: MainViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFoodBinding =
        FragmentFoodBinding.inflate(inflater, container, false)

    override fun setupViews() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            requireActivity().finish()
            mainActivity.showBottomMenu()
        }
    }
}