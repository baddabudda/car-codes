package com.forgblord.carcodes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RegionsListAdapter(
    private val codesDataset: List<Pair<String, List<Int>>>
): RecyclerView.Adapter<RegionsListAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val regionName: TextView
        val regionCodes: TextView

        init {
            regionName = view.findViewById(R.id.region_name)
            regionCodes = view.findViewById(R.id.region_codes)
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
        holder.regionName.text = codesDataset[position].first
        holder.regionCodes.text = listToText(codesDataset[position].second)
    }

    private fun listToText(codesList: List<Int>): CharSequence {
        return codesList.joinToString()
    }
}