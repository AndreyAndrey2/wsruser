package com.example.wsruserfood.ui.sauce

import android.view.LayoutInflater
import com.example.wsruserfood.ui.core.BaseFragment
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.viewModels
import com.example.wsruserfood.databinding.FragmentSauceBinding

import com.example.wsruserfood.viewmodel.main.MainViewModel

class SauceFragment: BaseFragment<MainViewModel, FragmentSauceBinding>() {

    override val viewModel: MainViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSauceBinding =
        FragmentSauceBinding.inflate(inflater, container, false)

    override fun setupViews() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            requireActivity().finish()
            mainActivity.showBottomMenu()
        }
    }
}