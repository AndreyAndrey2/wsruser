package com.example.wsruserfood.ui.main

import android.view.LayoutInflater
import com.example.wsruserfood.databinding.FragmentMainBinding
import com.example.wsruserfood.ui.core.BaseFragment
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.viewModels
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
//        setupTabLayoutAndPager()
    }

//    private fun setupTabLayoutAndPager() {
//        with(binding) {
//            val adapter = FragmentAdapter(childFragmentManager, lifecycle)
//
//            adapter.addFragment(TimetableFragment(), getString(R.string.tab_timetable))
//            adapter.addFragment(HomeworkFragment(), getString(R.string.tab_homework))
//            adapter.addFragment(WeatherFragment(), getString(R.string.tab_weather))
//
//            pager.adapter = adapter
//            TabLayoutMediator(tabLayout, pager) { tab, position ->
//                tab.text = adapter.getPageTitle(position)
//            }.attach()
//
//        }
//    }

}