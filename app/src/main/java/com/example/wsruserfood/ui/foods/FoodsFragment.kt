package com.example.wsruserfood.ui.foods

import com.example.wsruserfood.databinding.FragmentFoodsBinding
import android.view.LayoutInflater
import com.example.wsruserfood.ui.core.BaseFragment
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.wsruserfood.R
import com.example.wsruserfood.extensions.gone
import com.example.wsruserfood.extensions.visible

import com.example.wsruserfood.viewmodel.main.MainViewModel

class FoodsFragment: BaseFragment<MainViewModel, FragmentFoodsBinding>() {

    override val viewModel: MainViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFoodsBinding =
        FragmentFoodsBinding.inflate(inflater, container, false)

    override fun setupViews() {
        binding.eatBig.gone()
        binding.continueShop.gone()
        binding.goCart.gone()
        binding.btnBackTwo.gone()
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            requireActivity().finish()
            mainActivity.showBottomMenu()
        }
        with(binding) {
            eat1.setOnClickListener{
                eat1.gone()
                eat2.gone()
                eat3.gone()
                eat4.gone()
                food1.gone()
                food2.gone()
                food3.gone()
                food4.gone()
                eatBig.visible()
                eat5.gone()
            }
            btnBack.setOnClickListener{
                eat1.visible()
                eat2.visible()
                eat3.visible()
                eat4.visible()
                food1.visible()
                food2.visible()
                food3.visible()
                food4.visible()
                eatBig.gone()
                eat5.visible()
            }


            addCart.setOnClickListener{
                addCart.gone()
                continueShop.visible()
                goCart.visible()
                plus.gone()
                minus.gone()
                count.gone()
                btnBack.gone()
                btnBackTwo.visible()
            }

            btnBackTwo.setOnClickListener{
                addCart.visible()
                continueShop.gone()
                goCart.gone()
                plus.visible()
                minus.visible()
                count.visible()
                btnBack.visible()
                btnBackTwo.gone()
            }

            continueShop.setOnClickListener{
                continueShop.gone()
                goCart.gone()

                eat1.visible()
                eat2.visible()
                eat3.visible()
                eat4.visible()
                food1.visible()
                food2.visible()
                food3.visible()
                food4.visible()
                eatBig.gone()
                eat5.visible()

                addCart.visible()
                plus.visible()
                minus.visible()
                count.visible()
            }

            goCart.setOnClickListener{
                //findNavController().navigate(R.id.action_mainFragment_to_oneitemFragment)
            }

            more.setOnClickListener{
                findNavController().navigate(R.id.action_mainFragment_to_oneitemFragment)
            }

            plus.setOnClickListener{
                count.text = (count.text.toString().toInt() + 1).toString()
            }

            minus.setOnClickListener{
                count.text = (count.text.toString().toInt() - 1).toString()
            }
        }
    }
}