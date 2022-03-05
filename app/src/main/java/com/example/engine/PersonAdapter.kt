package com.example.engine

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.engine.databinding.ItemPersonBinding
import com.example.engine.model.Person

class PersonAdapter : ListAdapter<Person, PersonAdapter.PersonViewHolder>(getDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PersonViewHolder(parent)
    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) = holder.bind(getItem(position))

    class PersonViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
    ) {

        private val binding = ItemPersonBinding.bind(itemView)

        fun bind(person: Person) {
            with(binding) {
                textViewSurname.text = person.surname
            }
        }
    }

    companion object {
        private fun getDiffCallback() = object : DiffUtil.ItemCallback<Person>() {
            override fun areItemsTheSame(oldItem: Person, newItem: Person) = oldItem.surname == newItem.surname
            override fun areContentsTheSame(oldItem: Person, newItem: Person) = oldItem == newItem
        }
    }
}
