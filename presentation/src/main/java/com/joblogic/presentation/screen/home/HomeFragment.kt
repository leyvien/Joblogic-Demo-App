package com.joblogic.presentation.screen.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.joblogic.presentation.R
import com.joblogic.presentation.base.BaseFragment
import com.joblogic.presentation.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>(R.layout.fragment_home) {
    override val viewModel: HomeViewModel by viewModels()
    override val viewBinding: FragmentHomeBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewBinding){
            btCallList.setOnClickListener {
               findNavController().navigate(
                   HomeFragmentDirections.actionHomeFragmentToCallListingFragment()
               )
            }
            btBuyList.setOnClickListener {
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToBuyListingFragment()
                )
            }
            btSellList.setOnClickListener {
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToSellListingFragment()
                )
            }
        }
    }
}