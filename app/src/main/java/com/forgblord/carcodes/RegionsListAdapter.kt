package com.forgblord.carcodes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.forgblord.carcodes.data.Region
import com.forgblord.carcodes.data.regionsList

class RegionsListAdapter(
    private val recyclerPool: RecyclerView.RecycledViewPool = RecyclerView.RecycledViewPool()
): RecyclerView.Adapter<RegionsListAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val regionName: TextView
        val codesGrid: RecyclerView
        val context: Context

        init {
            regionName = view.findViewById(R.id.tv_region_name)
            codesGrid = view.findViewById(R.id.rv_region_codes)
            context = view.context
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_region_info, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return regionsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val region: Region = regionsList[position]
        val codesGridAdapter = CodesGridAdapter(region.codes)

        holder.regionName.text = region.name
        holder.codesGrid.layoutManager = GridLayoutManager(holder.context, 6)
        holder.codesGrid.adapter = codesGridAdapter
        holder.codesGrid.setRecycledViewPool(recyclerPool)
    }
}