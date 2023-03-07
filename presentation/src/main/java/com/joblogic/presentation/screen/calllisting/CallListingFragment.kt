package com.joblogic.presentation.screen.calllisting

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.joblogic.presentation.R
import com.joblogic.presentation.adapter.PersonAdapter
import com.joblogic.presentation.base.BaseFragment
import com.joblogic.presentation.databinding.FragmentCallListingBinding
import com.joblogic.presentation.screen.calllisting.model.CallListingUiState
import com.joblogic.presentation.utils.LinearLayoutItemDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CallListingFragment() :
    BaseFragment<CallListingViewModel, FragmentCallListingBinding>(R.layout.fragment_call_listing) {
    override val viewModel: CallListingViewModel by viewModels()
    override val viewBinding: FragmentCallListingBinding by viewBinding()

    private var personAdapter: PersonAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
        setupToolbar()
        setupRecyclerView()
    }

    private fun observeData() {
        viewModel.callItemsUiState.observe(viewLifecycleOwner) { uiState ->
            when (uiState) {
                is CallListingUiState.Loading ->
                    viewBinding.progressCircular.visibility = View.VISIBLE
                is CallListingUiState.Success -> {
                    personAdapter?.submitList(uiState.data)
                    viewBinding.progressCircular.visibility = View.GONE
                }
                is CallListingUiState.Error -> {
                    Toast.makeText(requireContext(), uiState.message, Toast.LENGTH_SHORT).show()
                    viewBinding.progressCircular.visibility = View.GONE
                }
            }
        }
    }

    private fun setupToolbar() {
        with(viewBinding.toolbar) {
            title = context.getString(R.string.call_list)
            setNavigationIcon(R.drawable.ic_back)
            setNavigationOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun setupRecyclerView() {
        personAdapter = PersonAdapter()
        viewBinding.rcCall.apply {
            adapter = personAdapter
            addItemDecoration(
                LinearLayoutItemDecoration(10, false)
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        personAdapter = null
        viewBinding.rcCall.adapter = null
    }
}