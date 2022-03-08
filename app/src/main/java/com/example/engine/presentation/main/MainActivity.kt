package com.example.engine.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.engine.databinding.ActivityMainBinding
import com.example.engine.domain.model.Person
import com.example.engine.presentation.core.SpaceItemDecoration
import com.example.engine.toDpInt
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val personAdapter by lazy {
        AsyncListDifferDelegationAdapter(
            getPersonDiffCallback(),
            getPersonAdapterDelegate()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        fillData()
    }

    private fun setupView() {
        with(binding) {
            searchPersonMainField.addTextChangedListener { search(it.toString()) }
            personMainList.apply {
                adapter = personAdapter
                addItemDecoration(SpaceItemDecoration(space = 5.toDpInt()))
            }
        }
    }

    private fun fillData() {
        personAdapter.items = Person.persons.toList()
    }

    private fun search(surname: String) {
        val filteredList = Person.persons.filter { person ->
            person.surname.contains(surname.toString(), true)
        }
        personAdapter.items = filteredList.toList()
    }
}