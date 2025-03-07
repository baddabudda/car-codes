package com.forgblord.carcodes

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.forgblord.carcodes.data.FederalSubject
import com.forgblord.carcodes.data.SubjectDataProvider
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {
    private lateinit var topAppbar: MaterialToolbar
    private lateinit var subjectsRecyclerView: RecyclerView
    private lateinit var subjectsListAdapter: FederalSubjectsListAdapter

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
        buildTopAppBarHandler()
    }

    private fun buildSubjectsRecyclerView() {
        subjectsRecyclerView = findViewById(R.id.rv_subjects)
        subjectsListAdapter = FederalSubjectsListAdapter(subjectsList=SubjectDataProvider.subjectList)

        subjectsRecyclerView.layoutManager = LinearLayoutManager(this)
        subjectsRecyclerView.adapter = subjectsListAdapter
    }

    private fun buildTopAppBarHandler() {
        topAppbar = findViewById(R.id.top_app_bar)

        topAppbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.search -> {
                    startSearch(menuItem)
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

    private fun startSearch(searchItem: MenuItem) {
        val searchView = searchItem.actionView as SearchView

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val filteredList: List<FederalSubject> = SubjectDataProvider.search(newText)
                subjectsListAdapter.updateList(filteredList)
                return false
            }
        })
    }
}