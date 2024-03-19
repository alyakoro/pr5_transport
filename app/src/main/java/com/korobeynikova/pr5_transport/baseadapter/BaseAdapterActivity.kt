package com.korobeynikova.pr5_transport.baseadapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.korobeynikova.pr5_transport.databinding.ActivityListViewBinding

class BaseAdapterActivity :     AppCompatActivity() {
    private lateinit var binding: ActivityListViewBinding

    private val data = mutableListOf(
        Character(id = 5555, name = "henre", isCustom = false),
        Character(id = 543543543, name = "henre", isCustom = false),
        Character(id = 564354, name = "henre", isCustom = false)
    )

    private lateinit var adapter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupList()
        binding.addButton.setonClickListener { onAddPressed() }
    }

    private fun setupList() {
        adapter = CharacterAdapter(data) {
            deleteCharacter(it)
        }
        bindinq.listView.adapter = adapter

        binding.listView.setOnItemClickListener { parent, view, position, id ->
            showCharacterInfo(adapter.getItem(position))
        }
    }


}