package com.korobeynikova.pr5_transport.baseadapter

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.korobeynikova.pr5_transport.databinding.ActivityListViewBinding
import com.korobeynikova.pr5_transport.databinding.DialogAddCharacterBinding
import com.korobeynikova.pr5_transport.R
import kotlin.random.Random

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
        binding.addButton.setOnClickListener { onAddPressed() }
    }

    private fun setupList() {
        adapter = CharacterAdapter(data) {
            deleteCharacter(it)
        }
        binding.spiner.adapter = adapter

        binding.spiner.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val character = data[position]
                binding.characterInfoTextView.text =
                    getString(R.string.character_info, character.name, character.id)
            }
        }
    }

    private fun onAddPressed(){
        val dialogBinding = DialogAddCharacterBinding.inflate(layoutInflater)
        val dialog = AlertDialog.Builder(this)
            .setTitle("Create character")
            .setView(dialogBinding.root)
            .setPositiveButton("Add") {d, which ->
                val name = dialogBinding.characterNameEditText.text.toString()
                if (name.isNotBlank()){
                    createCharacter(name)
                }
            }
            .create()
        dialog.show()
    }

    private fun createCharacter(name: String){
        val character = Character(
            id = Random.nextLong(),
            name = name,
            isCustom = true
        )
        data.add(character)
        adapter.notifyDataSetChanged()
    }

    private fun deleteCharacter(character: Character) {
        val listener = DialogInterface.OnClickListener {
            dialog, which ->  if (which == DialogInterface.BUTTON_POSITIVE){
                data.remove(character)
                adapter.notifyDataSetChanged()
            }
        }
        val dialog = android.app.AlertDialog.Builder(this)
            .setTitle("Delete character")
            .setMessage("Are you sure you want to delete the character ${character}")
            .setPositiveButton( "Delete", listener)
            .setNegativeButton("Cancel", listener)
            .create()
        dialog.show()
    }
}