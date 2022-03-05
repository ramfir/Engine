package com.example.engine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }

    private fun fillData() {
        personAdapter.submitList(Person.persons)
    }

    private fun setupRecyclerView() {
        with(binding) {
            recyclerViewPersons.adapter = personAdapter
        }
    }
}