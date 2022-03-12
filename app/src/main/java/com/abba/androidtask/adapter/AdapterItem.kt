package com.abba.androidtask.adapter

import android.content.Intent
import android.database.DataSetObserver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.abba.androidtask.R
import com.abba.androidtask.activity.ItemOne
import com.abba.androidtask.activity.ItemTwo
import com.abba.androidtask.activity.PageOne
import com.abba.androidtask.model.ItemModel
import java.util.ArrayList

class AdapterItem (private val mItemList: ArrayList<ItemModel>) : RecyclerView.Adapter<AdapterItem.ItemViewHolder>(), Adapter {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterItem.ItemViewHolder {
        val v: View =
            LayoutInflater.from(parent.context).inflate(R.layout.row_items, parent, false)
        return AdapterItem.ItemViewHolder(v)
    }


    override fun onBindViewHolder(holder: AdapterItem.ItemViewHolder, position: Int) {
        val item = mItemList[position]
        val animation = AnimationUtils.loadAnimation(PageOne.context, R.anim.fadeout)

        holder.image.setImageResource(item.image)
        holder.name.text = item.name
        holder.price.text = "AED"+item.price

        holder.layout.setOnClickListener { view ->
            view.startAnimation(animation)
            when {
                item.blocked -> {
                    Toast.makeText(PageOne.context, "Item Blocked", Toast.LENGTH_SHORT).show()
                }
                position == 0 -> {
                    PageOne.context.startActivity(Intent(PageOne.context, ItemOne::class.java))
                }
                position == 1 -> {
                    PageOne.context.startActivity(Intent(PageOne.context, ItemTwo::class.java))
                }
            }
        }

    }

    override fun getItemCount(): Int {
        return mItemList.size
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.imageView2)
        var price: TextView = itemView.findViewById(R.id.price)
        var name: TextView = itemView.findViewById(R.id.name)
        var layout: ConstraintLayout = itemView.findViewById(R.id.layout)

    }

    override fun registerDataSetObserver(observer: DataSetObserver?) {
        TODO("Not yet implemented")
    }

    override fun unregisterDataSetObserver(observer: DataSetObserver?) {
        TODO("Not yet implemented")
    }

    override fun getCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getItem(position: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        TODO("Not yet implemented")
    }

    override fun getViewTypeCount(): Int {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }


}