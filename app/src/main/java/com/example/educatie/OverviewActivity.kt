package com.example.educatie

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class OverviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overview)

        val cardData = listOf(
            CardItem("Matematica", "Description 1", 50),
            CardItem("Fizică", "Description 2", 100),
            // Adăugați mai multe elemente de card aici
        )

        val listView: ListView = findViewById(R.id.listViewOverview)

        val adapter = CardAdapter(this, cardData)
        listView.adapter = adapter
    }
}
