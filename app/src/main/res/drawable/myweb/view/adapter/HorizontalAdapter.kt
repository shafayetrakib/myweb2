package com.cellstechlimited.myweb.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cellstechlimited.myweb.R

class HorizontalAdapter (private val itemList: List<String>,private val imageItem: List<Int>) :
    RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder>() {

    class HorizontalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.Coin_icon_image)
        val textView: TextView = itemView.findViewById(R.id.Coin_name)
        val textView2: TextView = itemView.findViewById(R.id.coin_value)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.horizontaliy_layout, parent, false)
        return HorizontalViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
        // Bind your data here
        // holder.imageView.setImageResource(R.drawable.sample_image) // Example image resource
        //val Singleitem=itemList.get(position)
        holder.textView.text =itemList[position]
        holder.imageView.setImageResource(imageItem[position])
        //holder.textView2.text =
    }

    override fun getItemCount() = itemList.size
}
