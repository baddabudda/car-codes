package com.forgblord.carcodes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView.Recycler
import androidx.recyclerview.widget.RecyclerView.VERTICAL

class RegionsListAdapter(
    private val codesDataset: List<Pair<String, List<Int>>>,
    private val recyclerPool: RecyclerView.RecycledViewPool = RecyclerView.RecycledViewPool()
): RecyclerView.Adapter<RegionsListAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val regionName: TextView
        val codesGrid: RecyclerView
        val context: Context
        // val regionCodes: TextView

        init {
            regionName = view.findViewById(R.id.tv_region_name)
            codesGrid = view.findViewById(R.id.rv_region_codes)
            context = view.context
            // regionCodes = view.findViewById(R.id.region_codes)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_region_info, parent, false)

        return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return codesDataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val codesGridAdapter = CodesGridAdapter(codesDataset[position].second)

        holder.regionName.text = codesDataset[position].first
        holder.codesGrid.layoutManager = GridLayoutManager(holder.context, 6)
        holder.codesGrid.adapter = codesGridAdapter
        holder.codesGrid.setRecycledViewPool(recyclerPool)

        // holder.regionCodes.text = listToText(codesDataset[position].second)
    }

/*
    private fun listToText(codesList: List<Int>): CharSequence {
        return codesList.joinToString()
    }
*/
}