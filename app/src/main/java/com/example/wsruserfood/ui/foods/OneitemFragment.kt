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
import com.example.wsruserfood.ui.drinks.DrinksFragment
import com.example.wsruserfood.ui.eats.EatFragment
import com.example.wsruserfood.ui.eats.FoodFragment
import com.example.wsruserfood.ui.home.adapter.FragmentAdapter
import com.example.wsruserfood.ui.onboarding.adapter.OnBoardingAdapter
import com.example.wsruserfood.ui.sauce.SauceFragment
import com.example.wsruserfood.ui.snacks.SnacksFragment
import com.example.wsruserfood.viewmodel.main.MainViewModel
import com.google.android.material.tabs.TabLayoutMediator

class OneitemFragment: BaseFragment<MainViewModel, FragmentOneitemBinding>() {

    override val viewModel: MainViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentOneitemBinding =
        FragmentOneitemBinding.inflate(inflater, container, false)

    override fun setupViews() {
        mainActivity.hideBottomMenu()
        setupPager()
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
    private fun setupPager() {
        with(binding) {
            val adapter = OnBoardingAdapter(childFragmentManager, lifecycle)

            adapter.addFragment(EatFragment())
            adapter.addFragment(FoodFragment())
            adapter.addFragment(EatFragment())
            adapter.addFragment(FoodFragment())

            pager.adapter = adapter
            indicator.attachToPager(pager)
        }
    }
}