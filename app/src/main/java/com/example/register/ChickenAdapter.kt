package com.example.register

import android.content.ComponentCallbacks
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class ChickenAdapter() : RecyclerView.Adapter<ChickenAdapter.MyViewHolderCh>()  {
    var mref   : DatabaseReference?=null
    private lateinit var ChickenName :Array<String>
    private lateinit var ChickenPrice :Array<String>
    private lateinit var Chickenimg: Array<Int>

    constructor( ChickenName: Array<String>, ChickenPrice: Array<String>, Chickenimg: Array<Int>) :this(){
        this.ChickenName=ChickenName
        this.ChickenPrice=ChickenPrice
        this.Chickenimg=Chickenimg
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderCh {

        var cv = LayoutInflater.from(parent.context).inflate(R.layout.cardview_layout,parent,false)
        return MyViewHolderCh(cv)
    }

    override fun onBindViewHolder(holder: MyViewHolderCh, position: Int) {

        holder.names.setText(ChickenName[position])
        holder.prices.setText(ChickenPrice[position])
        holder.img.setImageResource(Chickenimg[position])

        holder.add.setOnClickListener(View.OnClickListener {
            mref = FirebaseDatabase.getInstance().getReference("authentication")
            var name = holder.names.text.toString()
            var price = holder.prices.text.toString()
            var id = mref?.push()!!.key
            var order = Model(id, name, price)
            mref!!.child(id.toString()).setValue(order)
            Toast.makeText(it.context,"Added to Cart Successfully",Toast.LENGTH_SHORT).show()

        })
    }

    override fun getItemCount(): Int {
        return ChickenName!!.size
    }
   inner class MyViewHolderCh(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var names = itemView.findViewById<TextView>(R.id.textView2)
        var prices = itemView.findViewById<TextView>(R.id.textView3)
        var img = itemView.findViewById<ImageView>(R.id.imageView)
       var cv = itemView.findViewById<CardView>(R.id.card)
       var add = itemView.findViewById<Button>(R.id.addtocart)

    }

}

