package ru.example.wsrfood.ui.onnoarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.viewModels
import com.example.wsruserfood.databinding.FragmentOnBoardindContainerBinding
import com.example.wsruserfood.ui.core.BaseFragment

import ru.example.wsrfood.ui.onnoarding.adapter.OnBoardingAdapter
import ru.example.wsrfood.viewmodel.core.EmptyViewModel
import ru.example.wsruserfood.ui.onnoarding.OnBoardingFragmentOne

class OnBoardingFragmentContainer :
    BaseFragment<EmptyViewModel, FragmentOnBoardindContainerBinding>() {
    override val viewModel: EmptyViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentOnBoardindContainerBinding =
        FragmentOnBoardindContainerBinding.inflate(inflater, container, false)

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