package com.joblogic.presentation.base

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VH: BaseViewModel, VB: ViewBinding>(layoutResId: Int): Fragment(layoutResId) {
    protected abstract val viewModel: VH
    protected abstract val viewBinding: VB
}