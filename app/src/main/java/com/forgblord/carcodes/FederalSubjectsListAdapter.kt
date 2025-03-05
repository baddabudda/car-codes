package com.forgblord.carcodes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.forgblord.carcodes.data.FederalSubject
import com.forgblord.carcodes.data.federalSubjectsList

class FederalSubjectsListAdapter(
    private val recyclerPool: RecyclerView.RecycledViewPool = RecyclerView.RecycledViewPool()
): RecyclerView.Adapter<FederalSubjectsListAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val subjectName: TextView
        val codesGrid: RecyclerView
        val context: Context

        init {
            subjectName = view.findViewById(R.id.tv_subject_name)
            codesGrid = view.findViewById(R.id.rv_subject_codes)
            context = view.context
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_subject_info, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return federalSubjectsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val subject: FederalSubject = federalSubjectsList[position]
        val codesGridAdapter = CodesGridAdapter(subject.codes)

        holder.subjectName.text = subject.name
        holder.codesGrid.layoutManager = GridLayoutManager(holder.context, 6)
        holder.codesGrid.adapter = codesGridAdapter
        holder.codesGrid.setRecycledViewPool(recyclerPool)
    }
}