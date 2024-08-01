package com.cellstechlimited.myweb.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cellstechlimited.myweb.R
import com.cellstechlimited.myweb.service.model.marketStatics

class tesAdapter ( var itemList: List<String>,var icon:List<Int>, var price:List<String>,var pricei:List<String> ) :
    RecyclerView.Adapter<tesAdapter.HorizontalViewHolder>() {

    class HorizontalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: ImageView = itemView.findViewById(R.id.Coin_icon_image)
        val textView1: TextView = itemView.findViewById(R.id.Coin_name)
        val textView3: TextView = itemView.findViewById(R.id.price)
        val textView2: TextView = itemView.findViewById(R.id.coin_value)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.test, parent, false)
        return HorizontalViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
        // Bind your data here
        // holder.imageView.setImageResource(R.drawable.sample_image) // Example image resource
        //val Singleitem=itemList.get(position)
        startAnimation(holder.itemView)
        holder.textView.setImageResource(icon[position])
       holder.textView1.text=itemList[position]
        holder.textView2.text= pricei[position]
        holder.textView3.text=price[position]

        //holder.textView2.text =
    }

    override fun getItemCount() = itemList.size

    fun startAnimation(view: View){
        val anim=AlphaAnimation(0.0f,1.0f)
        anim.duration=1000
        view.startAnimation(anim)
    }
}
