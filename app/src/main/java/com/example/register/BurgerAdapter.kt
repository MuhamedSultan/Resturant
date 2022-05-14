package com.example.register

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class BurgerAdapter() : RecyclerView.Adapter<BurgerAdapter.MyViewHolder>() {
    var mref   : DatabaseReference?=null
    private lateinit var burgername: Array<String>
    private lateinit var burgerprice: Array<String>
    private lateinit var burgerimg: Array<Int>


    constructor(burgername: Array<String>,burgerprice : Array<String>, burgerimg: Array<Int>) : this() {
        this.burgername=burgername
        this.burgerprice=burgerprice
        this.burgerimg=burgerimg
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val cv = LayoutInflater.from(parent.context).inflate(R.layout.cardview_layout,parent,false)
        return MyViewHolder(cv)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.names.setText(burgername[position])
        holder.prices.setText(burgerprice[position])
       holder.img.setImageResource(burgerimg[position])

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
        return burgername!!.size
    }
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var names=itemView.findViewById<TextView>(R.id.textView2)
        var prices=itemView.findViewById<TextView>(R.id.textView3)
        var img=itemView.findViewById<ImageView>(R.id.imageView)
       // var cv = itemView.findViewById<CardView>(R.id.card)
        var add = itemView.findViewById<Button>(R.id.addtocart)




    }


}
