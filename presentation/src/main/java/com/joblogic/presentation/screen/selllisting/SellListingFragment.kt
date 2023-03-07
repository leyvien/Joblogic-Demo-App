package com.joblogic.presentation.screen.selllisting

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.joblogic.presentation.R
import com.joblogic.presentation.base.BaseFragment
import com.joblogic.presentation.databinding.FragmentSellListingBinding
import com.joblogic.presentation.adapter.ItemAdapter
import com.joblogic.presentation.screen.selllisting.model.SellListingUiState
import com.joblogic.presentation.utils.LinearLayoutItemDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SellListingFragment() :
    BaseFragment<SellListingViewModel, FragmentSellListingBinding>(R.layout.fragment_sell_listing) {
    override val viewModel: SellListingViewModel by viewModels()
    override val viewBinding: FragmentSellListingBinding by viewBinding()

    private var itemAdapter: ItemAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
        setupToolbar()
        setupRecyclerView()
    }

    private fun observeData() {
        viewModel.sellItemsUiState.observe(viewLifecycleOwner) { uiState ->
            when (uiState) {
                is SellListingUiState.Loading ->
                    viewBinding.progressCircular.visibility = View.VISIBLE
                is SellListingUiState.Success -> {
                    itemAdapter?.submitList(uiState.data)
                    viewBinding.progressCircular.visibility = View.GONE
                }
                is SellListingUiState.Error -> {
                    Toast.makeText(requireContext(), uiState.message, Toast.LENGTH_SHORT).show()
                    viewBinding.progressCircular.visibility = View.GONE
                }
            }
        }
    }

    private fun setupToolbar() {
        with(viewBinding.toolbar) {
            title = context.getString(R.string.sell_list)
            setNavigationIcon(R.drawable.ic_back)
            setNavigationOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun setupRecyclerView() {
        itemAdapter = ItemAdapter()
        viewBinding.rcSell.apply {
            adapter = itemAdapter
            addItemDecoration(
                LinearLayoutItemDecoration(10, false)
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        itemAdapter = null
        viewBinding.rcSell.adapter = null
    }
}