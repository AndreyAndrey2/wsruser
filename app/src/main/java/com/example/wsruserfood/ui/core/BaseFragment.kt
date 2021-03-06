package com.example.wsruserfood.ui.core

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.example.wsruserfood.ui.MainActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import com.example.wsruserfood.extensions.gone
import com.example.wsruserfood.extensions.visible
import com.example.wsruserfood.viewmodel.core.BaseViewModel
import com.example.wsruserfood.viewmodel.core.Event

abstract class BaseFragment<T : BaseViewModel, VB : ViewBinding>
    : Fragment() {

    // Переменная для вью модели
    protected abstract val viewModel: T

    // Внутренняя переменная для биндинга
    private var _binding: VB? = null
    val binding get() = _binding!!

    // Инициализация биндинга
    abstract fun inflateViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    // Переменная MainActivity для использования во фрагментах
    protected val mainActivity: MainActivity get() = requireActivity() as MainActivity

    /**
     * Переменная для указания видимости навигации. При значении false делает навигацию невидимой.
     */
    protected var isNavigationEnabled: Boolean = true


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflateViewBinding(inflater, container)
        return binding.root
    }

    abstract fun setupViews()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    protected fun <T> observeResponse(
        flow: StateFlow<Event<T>>,
        collectFun: (Event<T>) -> Unit
    ) {
        lifecycleScope.launchWhenStarted {
            flow.collect {
                collectFun(it)
            }
        }
    }

    protected fun showErrorDialog(message: String = "Произошла ошибка") {
        MaterialAlertDialogBuilder(requireContext())
            .setMessage(message)
            .setPositiveButton("Продолжить", null)
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}