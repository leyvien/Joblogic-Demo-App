package com.joblogic.presentation.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView


class LinearLayoutItemDecoration(
    private val spacing: Int,
    private val isHorizontalLayout: Boolean = true,
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State,
    ) {
        if (isHorizontalLayout) {
            outRect.bottom = spacing
            outRect.right = spacing
            outRect.left = spacing
            outRect.top = spacing

        } else {
            outRect.bottom = spacing
            if (parent.getChildAdapterPosition(view) == 0)
                outRect.top = spacing
            else
                outRect.top = 0

        }
    }

}