package com.forgblord.carcodes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CodesGridAdapter(
    private val codes: List<Int>
): RecyclerView.Adapter<CodesGridAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val code: TextView

        init {
            code = view.findViewById(R.id.tv_code)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_code, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return codes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.code.text = formatCode(codes[position].toString())
    }

    private fun formatCode(code: String): String {
        if (code.length == 1) {
            return "0$code"
        }

        return code
    }
}