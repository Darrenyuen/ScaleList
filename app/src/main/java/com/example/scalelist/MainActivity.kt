package com.example.scalelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var adapter: ScaleSubListAdapter? = null
    private val dataList: ArrayList<ObbItem> = ArrayList<ObbItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.scaleSubList)
        val subSongList = ArrayList<String>()
        subSongList.add("东风")
        subSongList.add("南风")
        subSongList.add("西风")
        subSongList.add("北风")
        dataList.add(ObbItem("春天的风", subSongList))
        dataList.add(ObbItem("夏天的风", null))

        adapter = ScaleSubListAdapter(this, dataList)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = adapter
    }
}
