package com.example.wsruserfood.ui.onboarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.wsruserfood.R
import com.example.wsruserfood.databinding.FragmentOnboardingTwoBinding
import com.example.wsruserfood.ui.core.BaseFragment
import com.example.wsruserfood.viewmodel.core.EmptyViewModel

class OnBoardingFragmentTwo: BaseFragment<EmptyViewModel, FragmentOnboardingTwoBinding>() {

    override val viewModel: EmptyViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentOnboardingTwoBinding =
        FragmentOnboardingTwoBinding.inflate(inflater, container, false)

    override fun setupViews() {
        with(binding) {
            btnSignIn.setOnClickListener {
                findNavController().navigate(R.id.action_onBoardingFragmentContainer_to_signIn)
            }
            btnSignUp.setOnClickListener {
                findNavController().navigate(R.id.action_onBoardingFragmentContainer_to_signUp)
            }
            withoutAuth.setOnClickListener {
                findNavController().navigate(R.id.action_onBoardingFragmentContainer_to_mainFragment)
            }
        }
    }
}