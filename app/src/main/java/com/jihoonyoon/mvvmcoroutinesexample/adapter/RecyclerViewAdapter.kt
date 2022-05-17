package com.jihoonyoon.mvvmcoroutinesexample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jihoonyoon.mvvmcoroutinesexample.R
import com.jihoonyoon.mvvmcoroutinesexample.model.RecyclerData

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    private var items = ArrayList<RecyclerData>()

    fun setUpdatedData(items: ArrayList<RecyclerData>){
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
        = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_list_row ,parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageThumb = view.findViewById<ImageView>(R.id.imageThumb)
        private val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        private val tvDesc = view.findViewById<TextView>(R.id.tvDesc)

        fun bind(data: RecyclerData){
            tvTitle.text = data.name
            tvDesc.text = data.description

            Glide
                .with(imageThumb.context)
                .load(data.owner.avatar_url)
                .into(imageThumb)
        }
    }


}