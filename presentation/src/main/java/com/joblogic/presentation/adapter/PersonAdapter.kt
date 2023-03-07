package com.joblogic.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.joblogic.domain.model.Person
import com.joblogic.presentation.R
import com.joblogic.presentation.databinding.AdapterPersonItemViewBinding

class PersonAdapter() : ListAdapter<Person, PersonAdapter.PersonViewHolder>(PersonDiffCallback) {

    class PersonViewHolder(private val binding: AdapterPersonItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(person: Person) {
            with(binding) {
                tvPersonName.text =
                    tvPersonName.context.getString(
                        R.string.person_name,
                        person.name
                    )
                tvPersonNumber.text =
                    tvPersonNumber.context.getString(
                        R.string.person_number,
                        person.number.toString()
                    )

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder(
            AdapterPersonItemViewBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}

object PersonDiffCallback : DiffUtil.ItemCallback<Person>() {
    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem == newItem
    }

}