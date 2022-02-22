package com.example.wsruserfood.ui.onboarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.wsruserfood.databinding.FragmentOnboardingOneBinding
import com.example.wsruserfood.ui.core.BaseFragment
import com.example.wsruserfood.viewmodel.core.EmptyViewModel


class OnBoardingFragmentOne: BaseFragment<EmptyViewModel, FragmentOnboardingOneBinding>() {

    override val viewModel: EmptyViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentOnboardingOneBinding =
        FragmentOnboardingOneBinding.inflate(inflater, container, false)

    override fun setupViews() {

    }
}