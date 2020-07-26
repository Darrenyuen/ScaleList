package com.example.scalelist

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

/**
 *yuan
 *2020/7/26
 **/
class ScaleSubListAdapter(private val context: Context, private val obbList: ArrayList<ObbItem>): RecyclerView.Adapter<ScaleSubListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return obbList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val obbItem = obbList[position]
        Log.i("Adapter", obbItem.songName)
        holder.bindData(obbList)
//        holder.ordinalTV?.text = obbItem.songName
//        if (obbItem.subSong != null && obbItem.subSong.isNotEmpty()) {
//            holder.showMoreBtn?.visibility = View.VISIBLE
//            holder.showMoreBtn?.setOnClickListener {
//                dealShowMore(obbItem)
//            }
//        }
    }

    private fun dealShowMore(obbItem: ObbItem) {
        obbItem.subSong?.forEach {
            obbList.add(ObbItem(it, null))
        }
        notifyDataSetChanged()
        Toast.makeText(context, "dealShowMore", Toast.LENGTH_SHORT).show()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ordinalTV: TextView? = null
        var showMoreBtn: Button? = null
        init {
            ordinalTV = itemView.findViewById(R.id.ordinal)
            showMoreBtn = itemView.findViewById(R.id.showMore)
        }
        fun bindData(obbList: ArrayList<ObbItem>) {

        }
    }
}