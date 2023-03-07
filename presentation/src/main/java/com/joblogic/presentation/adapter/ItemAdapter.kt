package com.joblogic.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.joblogic.domain.model.Item
import com.joblogic.presentation.R
import com.joblogic.presentation.databinding.AdapterItemViewBinding

class ItemAdapter() : ListAdapter<Item, ItemAdapter.ItemViewHolder>(BuyItemDiffCallback) {

    class ItemViewHolder(private val binding: AdapterItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(buyItem: Item) {
            with(binding) {
                tvItemName.text =
                    tvItemName.context.getString(
                        R.string.item_name,
                        buyItem.name
                    )
                tvItemPrice.text =
                    tvItemPrice.context.getString(
                        R.string.item_price,
                        buyItem.price.toString()
                    )
                tvItemQuantity.text =
                    tvItemQuantity.context.getString(
                        R.string.item_quantity,
                        buyItem.quantity.toString()
                    )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            AdapterItemViewBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}

object BuyItemDiffCallback : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }

}