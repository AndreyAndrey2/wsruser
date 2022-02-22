package com.example.wsruserfood.ui.foods

import com.example.wsruserfood.databinding.FragmentFoodsBinding
import android.view.LayoutInflater
import com.example.wsruserfood.ui.core.BaseFragment
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.wsruserfood.R
import com.example.wsruserfood.extensions.gone
import com.example.wsruserfood.extensions.visible

import com.example.wsruserfood.viewmodel.main.MainViewModel

class FoodsFragment: BaseFragment<MainViewModel, FragmentFoodsBinding>() {

    override val viewModel: MainViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFoodsBinding =
        FragmentFoodsBinding.inflate(inflater, container, false)

    override fun setupViews() {
        binding.eatBig.gone()
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            requireActivity().finish()
            mainActivity.showBottomMenu()
        }
        with(binding) {
            eat1.setOnClickListener{
                eat1.gone()
                eat2.gone()
                eat3.gone()
                eat4.gone()
                food1.gone()
                food2.gone()
                food3.gone()
                food4.gone()
                eatBig.visible()
            }
            btnBack.setOnClickListener{
                eat1.visible()
                eat2.visible()
                eat3.visible()
                eat4.visible()
                food1.visible()
                food2.visible()
                food3.visible()
                food4.visible()
                eatBig.gone()
            }
        }
    }
}