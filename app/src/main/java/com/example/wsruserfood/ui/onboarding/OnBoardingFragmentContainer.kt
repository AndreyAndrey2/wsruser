package com.example.wsruserfood.ui.onboarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.viewModels
import com.example.wsruserfood.databinding.FragmentOnBoardindContainerBinding
import com.example.wsruserfood.ui.core.BaseFragment
import com.example.wsruserfood.ui.onboarding.adapter.OnBoardingAdapter
import com.example.wsruserfood.viewmodel.core.EmptyViewModel
import com.example.wsruserfood.ui.onboarding.OnBoardingFragmentOne

class OnBoardingFragmentContainer :
    BaseFragment<EmptyViewModel, FragmentOnBoardindContainerBinding>() {
    override val viewModel: EmptyViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentOnBoardindContainerBinding =
        FragmentOnBoardindContainerBinding.inflate(inflater, container, false)

    override fun onStart() {
        super.onStart()
    }

    override fun setupViews() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            requireActivity().finish()
        }
        setupPager()
    }

    private fun setupPager() {
        with(binding) {
            val adapter = OnBoardingAdapter(childFragmentManager, lifecycle)

            adapter.addFragment(OnBoardingFragmentOne())
            adapter.addFragment(OnBoardingFragmentTwo())

            pager.adapter = adapter
            indicator.attachToPager(pager)
        }
    }


}