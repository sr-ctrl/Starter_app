package com.example.starterapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.starterapp.R

class RecyclerView_Adapter(private val listViewType: List<Int>) : RecyclerView.Adapter<RecyclerView_Adapter.ViewHolder>() {

    companion object {
        val item_a = 0
        val item_b = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            item_a-> ViewHolderItemA(inflater.inflate(R.layout.recycler_item_a, null))
            else -> ViewHolderItemB(inflater.inflate(R.layout.recycler_item_b, null))
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val viewType = listViewType[position]
    }

    override fun getItemCount(): Int = listViewType.size

    override fun getItemViewType(position: Int): Int = listViewType[position]

    open inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    inner class ViewHolderItemA(itemView: View) : ViewHolder(itemView) {

    }

    inner class ViewHolderItemB(itemView: View) : ViewHolder(itemView)

}


