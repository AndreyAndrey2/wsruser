package com.example.wsruserfood.ui.signin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.wsruserfood.R
import com.example.wsruserfood.databinding.FragmentSignInBinding
import com.example.wsruserfood.ui.core.BaseFragment
import com.wajahatkarim3.easyvalidation.core.view_ktx.validator
import ru.example.wsruserfood.viewmodel.core.Status
import ru.example.wsruserfood.viewmodel.signin.SignInViewModel

class SignIn : BaseFragment<SignInViewModel, FragmentSignInBinding>() {

    override val viewModel: SignInViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSignInBinding =
        FragmentSignInBinding.inflate(inflater, container, false)

    override fun setupViews() {
        with(binding){
            btnLogin.setOnClickListener {
                tietEmail.text.
                toString()
                    .validator()
                    .validEmail()
                    .addErrorCallback {
                        viewModel.isValid = false
                    }
                    .check()

                tietPassword.text
                    .toString()
                    .validator()
                    .nonEmpty()
                    .addErrorCallback {
                        viewModel.isValid = false
                    }
                    .check()

                if (!viewModel.isValid) showErrorDialog("Неверный логин или пароль")
                else {
                    viewModel.postAuth(
                        tietEmail.text.toString(),
                        tietPassword.text.toString()
                    )
                    observeResponse(viewModel.authRequest) {
                        when (it.status) {
                            Status.SUCCESS -> {
                                findNavController().navigate(R.id.action_signIn_to_mainFragment)
                            }
                            Status.ERROR -> {
                                showErrorDialog()
                            }
                        }
                    }
                }
            }
        }
    }
}