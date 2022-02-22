package com.example.wsruserfood.ui.main

import android.view.LayoutInflater
import com.example.wsruserfood.databinding.FragmentMainBinding
import com.example.wsruserfood.ui.core.BaseFragment
import ru.example.wsrfood.viewmodel.main.MainViewModel
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.viewModels

class MainFragment: BaseFragment<MainViewModel, FragmentMainBinding>() {

    override val viewModel: MainViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMainBinding =
        FragmentMainBinding.inflate(inflater, container, false)

    override fun setupViews() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            requireActivity().finish()
        }
    }
}