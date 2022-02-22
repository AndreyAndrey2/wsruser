package com.example.wsruserfood.ui.main

import android.view.LayoutInflater
import com.example.wsruserfood.databinding.FragmentMainBinding
import com.example.wsruserfood.ui.core.BaseFragment
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.viewModels
import com.example.wsruserfood.R
import com.example.wsruserfood.ui.drinks.DrinksFragment
import com.example.wsruserfood.ui.foods.FoodsFragment
import com.example.wsruserfood.ui.home.adapter.FragmentAdapter
import com.example.wsruserfood.ui.sauce.SauceFragment
import com.example.wsruserfood.ui.snacks.SnacksFragment
import com.example.wsruserfood.viewmodel.main.MainViewModel
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment: BaseFragment<MainViewModel, FragmentMainBinding>() {

    override val viewModel: MainViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMainBinding =
        FragmentMainBinding.inflate(inflater, container, false)

    override fun setupViews() {
        mainActivity.showBottomMenu()
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            requireActivity().finish()
        }
    }

    override fun onStart() {
        super.onStart()
        setupTabLayoutAndPager()
    }

    private fun setupTabLayoutAndPager() {
        with(binding) {
            val adapter = FragmentAdapter(childFragmentManager, lifecycle)

            adapter.addFragment(FoodsFragment(), getString(R.string.foods))
            adapter.addFragment(DrinksFragment(), getString(R.string.drinks))
            adapter.addFragment(SnacksFragment(), getString(R.string.snacks))
            adapter.addFragment(SauceFragment(), getString(R.string.sauce))

            pager.adapter = adapter
            TabLayoutMediator(tabLayout, pager) { tab, position ->
                tab.text = adapter.getPageTitle(position)
            }.attach()

        }
    }

}