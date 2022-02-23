package com.example.wsruserfood.ui.main

import android.os.Handler
import android.os.Looper
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import com.example.wsruserfood.databinding.FragmentMainBinding
import com.example.wsruserfood.ui.core.BaseFragment
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.activity.addCallback
import androidx.core.view.isInvisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.wsruserfood.R
import com.example.wsruserfood.extensions.gone
import com.example.wsruserfood.extensions.invisible
import com.example.wsruserfood.extensions.visible
import com.example.wsruserfood.ui.drinks.DrinksFragment
import com.example.wsruserfood.ui.foods.FoodsFragment
import com.example.wsruserfood.ui.home.adapter.FragmentAdapter
import com.example.wsruserfood.ui.sauce.SauceFragment
import com.example.wsruserfood.ui.snacks.SnacksFragment
import com.example.wsruserfood.viewmodel.main.MainViewModel
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.delay

class MainFragment: BaseFragment<MainViewModel, FragmentMainBinding>() {

    override val viewModel: MainViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMainBinding =
        FragmentMainBinding.inflate(inflater, container, false)

    override fun setupViews() {
        binding.tvResults.invisible()
        binding.backWhite.gone()
        binding.close.gone()
        binding.add2.invisible()
        mainActivity.showBottomMenu()
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            requireActivity().finish()
        }
        with(binding){

            add.setOnClickListener {
                val ProfsLeft: Animation = AnimationUtils.loadAnimation(activity, R.anim.sk)
                add2.startAnimation(ProfsLeft)
                add.visible()
                add.gone()
                Thread.sleep(500)
                add2.gone()
            }

            icSearch.setOnClickListener{
                backWhite.visible()
                close.visible()
                icSend.invisible()
                editText.hint = "Search"
            }

            close.setOnClickListener{
                backWhite.gone()
                close.gone()
                icSend.visible()
                tabLayout.visible()
                tvResults.gone()
                editText.hint = "Выберите адрес доставки"
            }
        }
    }

    override fun onStart() {
        super.onStart()
        setupTabLayoutAndPager()
        binding.editText.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                //Perform Code
                if (binding.editText.text.toString() != "") {

                    binding.tabLayout.invisible()
                    binding.tvResults.visible()
                    binding.close.visible()
                    binding.icSend.invisible()
                    binding.tvResults.text = "Results"
                }
                return@OnKeyListener true
            }
            false
        })
    }

//    fun myDelay() {
//        while (binding.editText.text.toString() == ""){
//            if (binding.editText.text.toString() != ""){
//                Handler(Looper.getMainLooper()).postDelayed({
//                    binding.tabLayout.gone()
//                    binding.tvResults.visible()
//                }, 1000)
//            }
//        }
//    }

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