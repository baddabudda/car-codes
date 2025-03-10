package com.forgblord.carcodes

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.forgblord.carcodes.data.FederalSubject
import com.forgblord.carcodes.data.FederalSubjectsList
import com.forgblord.carcodes.data.SortOrder
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {
    private lateinit var topAppbar: MaterialToolbar
    private lateinit var subjectsRecyclerView: RecyclerView
    private lateinit var subjectsListAdapter: FederalSubjectsListAdapter

    companion object {
        const val KEY_SORT_ORDER = "SORT_ORDER"
        val DEFAULT_SORT_ORDER = SortOrder.BY_CODE
    }

    private val backPressedCallback = object: OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            val searchView = topAppbar.menu.findItem(R.id.search).actionView as SearchView

            if (!searchView.isIconified) {
                topAppbar.collapseActionView()
            } else {
                this.isEnabled = false
                finish()
            }
        }

    }

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
        handleBackPress()
    }

    private fun buildSubjectsRecyclerView() {
        subjectsRecyclerView = findViewById(R.id.rv_subjects)

        val data = restoreData()
        subjectsListAdapter = FederalSubjectsListAdapter(subjectsList=data)

        subjectsRecyclerView.layoutManager = LinearLayoutManager(this)
        subjectsRecyclerView.adapter = subjectsListAdapter
    }

    private fun restoreData(): List<FederalSubject> {
        val orderPreference = restoreOrderPreference()
        return FederalSubjectsList.sort(orderPreference)
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
                    true
                }
                R.id.sort_by_subject -> {
                    startSort(SortOrder.BY_NAME)
                    true
                }
                R.id.sort_by_code -> {
                    startSort(SortOrder.BY_CODE)
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
                val filteredList: List<FederalSubject> = FederalSubjectsList.search(newText)
                subjectsListAdapter.updateList(filteredList)
                return false
            }
        })
    }

    private fun startSort(order: SortOrder) {
        val sortedList: List<FederalSubject> = FederalSubjectsList.sort(order)
        subjectsListAdapter.updateList(sortedList)
        saveOrderPreference(order)
    }

    private fun saveOrderPreference(order: SortOrder) {
        val sharedPreference = this.getPreferences(Context.MODE_PRIVATE)
        with (sharedPreference.edit()) {
            putString(KEY_SORT_ORDER, order.name)
            apply()
        }
    }

    private fun restoreOrderPreference(): SortOrder {
        val sharedPreference = this.getPreferences(Context.MODE_PRIVATE)
        val orderCode = sharedPreference.getString(KEY_SORT_ORDER, SortOrder.BY_CODE.name)

        if (orderCode == null) {
            return DEFAULT_SORT_ORDER
        }

        return SortOrder.valueOf(orderCode)
    }

    private fun handleBackPress() {
        this.onBackPressedDispatcher.addCallback(this, backPressedCallback)
    }
}