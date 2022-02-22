package com.example.wsruserfood.ui.drinks

import android.view.LayoutInflater
import com.example.wsruserfood.ui.core.BaseFragment
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.viewModels
import com.example.wsruserfood.databinding.FragmentDrinksBinding
import com.example.wsruserfood.viewmodel.main.MainViewModel

class DrinksFragment: BaseFragment<MainViewModel, FragmentDrinksBinding>() {

    override val viewModel: MainViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDrinksBinding =
        FragmentDrinksBinding.inflate(inflater, container, false)

    override fun setupViews() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            requireActivity().finish()
            mainActivity.showBottomMenu()
        }
    }
}