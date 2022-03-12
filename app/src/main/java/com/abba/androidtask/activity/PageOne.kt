package com.abba.androidtask.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abba.androidtask.R
import com.abba.androidtask.adapter.AdapterItem
import com.abba.androidtask.model.ItemModel
import com.abba.androidtask.util.SSP
import java.util.ArrayList

class PageOne : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter
    private lateinit var itemList: ArrayList<ItemModel>
    private lateinit var layoutManager: RecyclerView.LayoutManager
    var ssp: SSP = SSP()
    companion object {
        lateinit var context: Context
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_one)

        context = this;

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        itemList = ArrayList<ItemModel>()
        itemList.add(ItemModel(false,"Adidas Shoe", 800, 1, R.drawable.a))
        itemList.add(ItemModel(ssp.getItemStatus(this),"Nike Shoe", 400, 2, R.drawable.b))
        itemList.add(ItemModel(true,"Ring", 100, 3, R.drawable.c))
        itemList.add(ItemModel(true,"Watch", 1000, 4, R.drawable.d))
        itemList.add(ItemModel(true,"Glasses", 1400, 5, R.drawable.e))

        adapter = AdapterItem(itemList)
        recyclerView.adapter = adapter as AdapterItem

        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)


    }
}