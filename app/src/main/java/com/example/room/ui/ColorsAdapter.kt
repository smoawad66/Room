package com.example.room.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.room.R
import com.example.room.models.Color
import android.graphics.Color.parseColor

class ColorsAdapter(private var data: List<Color>) : RecyclerView.Adapter<ColorsAdapter.ViewHolder>() {

    fun setData(data: List<Color>) {
        this.data = data
    }

    fun getData() = data


    private var listener: OnItemClickListener? = null
    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    inner class ViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        val tv_color: TextView = itemView.findViewById(R.id.tv_color)

        init {
            itemView.setOnClickListener { listener?.onItemClick(adapterPosition) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hex = '#'.plus(data[position].hex)
        holder.tv_color.text = hex
        holder.tv_color.setBackgroundColor(parseColor(hex))
    }

    override fun getItemCount(): Int = data.size
}