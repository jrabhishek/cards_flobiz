package com.example.cards

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cards.Models.Item


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedpreferences = getSharedPreferences("prefrence", Context.MODE_PRIVATE)
        val out = sharedpreferences.getBoolean("show",true)
        if(!out){
            val card:CardView = findViewById(R.id.card_ad)
            card.visibility = View.GONE
        }
        val cross:ImageButton = findViewById(R.id.imgbutton)
        cross.setOnClickListener {
            val editor = sharedpreferences.edit()
            editor.putBoolean("show",false)
            editor.commit()
            val card:CardView = findViewById(R.id.card_ad)
            card.visibility = View.GONE
        }
        val myItem = ArrayList<Item>()
        myItem.add(Item("https://place-puppy.com/300x300","some dog","18th aug"))
        myItem.add(Item("https://place-puppy.com/300x300","some dog","18th aug"))
        myItem.add(Item("https://place-puppy.com/300x300","some dog","18th aug"))
        myItem.add(Item("https://place-puppy.com/300x300","some dog","18th aug"))
        myItem.add(Item("https://place-puppy.com/300x300","some dog","18th aug"))
        myItem.add(Item("https://place-puppy.com/300x300","some dog","18th aug"))
        myItem.add(Item("https://place-puppy.com/300x300","some dog","18th aug"))
        myItem.add(Item("https://place-puppy.com/300x300","some dog","18th aug"))
        myItem.add(Item("https://place-puppy.com/300x300","some dog","18th aug"))
        myItem.add(Item("https://place-puppy.com/300x300","some dog","18th aug"))
        myItem.add(Item("https://place-puppy.com/300x300","some dog","18th aug"))



        val recyclerView:RecyclerView = findViewById(R.id.list_View)
        val myAdapter :CustomAdapter = CustomAdapter(myItem,this)
        recyclerView.layoutManager = LinearLayoutManager(this)
       recyclerView.adapter =  myAdapter


    }
}