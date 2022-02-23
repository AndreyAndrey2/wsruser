package com.example.wsruserfood.ui.splash

import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.wsruserfood.R
import com.example.wsruserfood.databinding.FragmentSplashBinding
import com.example.wsruserfood.ui.core.BaseFragment
import com.example.wsruserfood.viewmodel.core.Status
import com.example.wsruserfood.viewmodel.splash.SplashViewModel
import com.example.wsruserfood.extensions.gone
import com.example.wsruserfood.extensions.isOnline
import com.example.wsruserfood.extensions.showToast



class SplashFragment : BaseFragment<SplashViewModel, FragmentSplashBinding>() {

    override val viewModel: SplashViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSplashBinding =
        FragmentSplashBinding.inflate(inflater, container, false)

    override fun onStart() {
        super.onStart()
    }

    override fun setupViews() {
        if (!requireContext().isOnline()) {
            binding.progressBar.gone()
            Handler(Looper.getMainLooper()).postDelayed({
                findNavController().navigate(R.id.action_splashFragment_to_mainFragment)
            }, 1000)
        }

        viewModel.setupDatabase(requireContext())
        viewModel.getVersion()

        observeVersions()
        observeDishes()
    }

    private fun observeVersions() {
        observeResponse(viewModel.version) {
            when (it.status) {
                Status.SUCCESS -> {
                    if (!viewModel.isVersionsEquals.value) {
                        viewModel.getDishes()
                        viewModel.insertVersionsInDb()
                    } else {
                        findNavController().navigate(R.id.action_splashFragment_to_onBoardingFragmentContainer)
                    }
                }
                Status.ERROR -> {
                    showErrorDialog()
                }
                else -> {}
            }
        }
    }

    private fun observeDishes() {
        observeResponse(viewModel.dishes) {
            when (it.status) {
                Status.SUCCESS -> {
                    viewModel.insertDishesInDb()
                    showToast(it.data.toString())
                }
                Status.ERROR -> {
                    showErrorDialog()
                }
                else -> {}
            }
        }
    }
}