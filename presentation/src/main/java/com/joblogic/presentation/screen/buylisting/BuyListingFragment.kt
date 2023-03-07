package com.joblogic.presentation.screen.buylisting

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.joblogic.presentation.R
import com.joblogic.presentation.adapter.ItemAdapter
import com.joblogic.presentation.base.BaseFragment
import com.joblogic.presentation.databinding.FragmentBuyListingBinding
import com.joblogic.presentation.screen.buylisting.model.BuyListingUiState
import com.joblogic.presentation.utils.LinearLayoutItemDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BuyListingFragment :
    BaseFragment<BuyListingViewModel, FragmentBuyListingBinding>(R.layout.fragment_buy_listing) {
    override val viewModel: BuyListingViewModel by viewModels()
    override val viewBinding: FragmentBuyListingBinding by viewBinding()

    private var itemAdapter: ItemAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
        setupToolbar()
        setupRecyclerView()
    }

    private fun observeData() {
        viewModel.buyItemsUiState.observe(viewLifecycleOwner) { uiState ->
            when (uiState) {
                is BuyListingUiState.Loading ->
                    viewBinding.progressCircular.visibility = View.VISIBLE
                is BuyListingUiState.Success -> {
                    itemAdapter?.submitList(uiState.data)
                    viewBinding.progressCircular.visibility = View.GONE
                }
                is BuyListingUiState.Error -> {
                    Toast.makeText(requireContext(), uiState.message, Toast.LENGTH_SHORT).show()
                    viewBinding.progressCircular.visibility = View.GONE
                }
            }
        }
    }

    private fun setupToolbar() {
        with(viewBinding.toolbar) {
            title = context.getString(R.string.buy_list)
            setNavigationIcon(R.drawable.ic_back)
            setNavigationOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun setupRecyclerView() {
        itemAdapter = ItemAdapter()
        viewBinding.rcBuy.apply {
            adapter = itemAdapter
            addItemDecoration(
               LinearLayoutItemDecoration(10, false)
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        itemAdapter = null
        viewBinding.rcBuy.adapter = null
    }
}