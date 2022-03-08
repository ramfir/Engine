package com.example.engine

import androidx.recyclerview.widget.DiffUtil
import com.example.engine.databinding.ItemPersonBinding
import com.example.engine.model.Person
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun getPersonAdapterDelegate() = adapterDelegateViewBinding<Person, Person, ItemPersonBinding>(
    { layoutInflater, root -> ItemPersonBinding.inflate(layoutInflater, root, false) }
) {
    bind {
        binding.surnameItemPersonText.text = item.surname
    }
}

fun getPersonDiffCallback() = object : DiffUtil.ItemCallback<Person>() {
    override fun areItemsTheSame(oldItem: Person, newItem: Person) = oldItem.surname == newItem.surname
    override fun areContentsTheSame(oldItem: Person, newItem: Person) = oldItem == newItem
}