package com.korobeynikova.pr5_transport

import androidx.appcompat.app.AppCompatActivity
import android.widget.SimpleAdapter
import android.os.Bundle
import com.korobeynikova.pr5_transport.databinding.ActivitySimpleListViewBinding

class SimpleAdapterActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySimpleListViewBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListViewSimple()
    }

    private fun setupListViewSimple() {
        val data = listOf(
            mapOf(
                KEY_TITLE to "Заголовок 1-го элемента",
                KEY_DESCRIPTION to "Содержимое для первого элемента"
            ),
            mapOf(
                KEY_TITLE to "Заголовок 2-го элемента",
                KEY_DESCRIPTION to "Содержимое для второго элемента"
            ),
            mapOf(
                KEY_TITLE to "Заголовок 3-го элемента",
                KEY_DESCRIPTION to "Содержимое для третьего элемента"
            )
        )

        val adapter = SimpleAdapter(
            this, data, android.R.layout.simple_list_item_2,
            arrayOf(KEY_TITLE, KEY_DESCRIPTION),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )
        binding.listView.adapter = adapter

    }

    companion object {
        @JvmStatic
        val KEY_TITLE = "title"

        @JvmStatic
        val KEY_DESCRIPTION = "description"
    }
}
