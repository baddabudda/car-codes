package com.forgblord.carcodes

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {
    private lateinit var topAppbar: MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buildSubjectsRecyclerView()
        topAppbarHandler()
    }

    private fun buildSubjectsRecyclerView() {
        val subjectsRecyclerView: RecyclerView = findViewById(R.id.rv_subjects)
        val subjectsListAdapter = FederalSubjectsListAdapter()

        subjectsRecyclerView.layoutManager = LinearLayoutManager(this)
        subjectsRecyclerView.adapter = subjectsListAdapter
    }

    private fun topAppbarHandler() {
        topAppbar = findViewById(R.id.top_app_bar)

        topAppbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.search -> {
                    // TODO: add searching function
                    true
                }
                R.id.sort -> {
                    // TODO: add sorting function
                    true
                }
                else -> false
            }
        }
    }
}