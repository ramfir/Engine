package com.example.engine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.engine.databinding.ActivityMainBinding
import com.example.engine.model.Person

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val personAdapter = PersonAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        fillData()
        setupSearchProcess()
    }

    private fun setupRecyclerView() {
        with(binding) {
            recyclerViewPersons.apply {
                adapter = personAdapter
                addItemDecoration(
                    DividerItemDecoration(this@MainActivity, LinearLayoutManager.VERTICAL))
            }
        }
    }

    private fun fillData() {
        personAdapter.submitList(Person.persons)
    }

    private fun setupSearchProcess() {
        binding.editTextSearchSurname.addTextChangedListener { surname ->
            val filteredList = Person.persons.filter { person ->
                person.surname.contains(surname.toString(), true)}
            personAdapter.submitList(filteredList)
        }
    }
}