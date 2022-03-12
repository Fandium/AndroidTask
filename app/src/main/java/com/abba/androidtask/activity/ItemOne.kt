package com.abba.androidtask.activity

import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.abba.androidtask.R
import com.abba.androidtask.util.SSP

class ItemOne : AppCompatActivity() {
    private lateinit var check: CheckBox
    private lateinit var confirm: ImageButton
    val animation = AnimationUtils.loadAnimation(PageOne.context, R.anim.fadeout)
    var ssp: SSP = SSP()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_one)

        check = findViewById(R.id.checkBox)
        confirm = findViewById(R.id.confirm)

        if (!ssp.getItemStatus(this)) {
            check.isChecked = true
        }

        confirm.setOnClickListener { view ->
            if (check.isChecked){
                view.startAnimation(animation)
                ssp.setItemStatus(this,false)
                Toast.makeText(PageOne.context, "Item 2 unblocked", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, PageOne::class.java))
            }
            else{
                Toast.makeText(PageOne.context, "check the box first", Toast.LENGTH_SHORT).show()
            }


        }



    }
}