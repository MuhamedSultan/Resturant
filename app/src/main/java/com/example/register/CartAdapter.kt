package com.example.register

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CartAdapter() : RecyclerView.Adapter<CartAdapter.CartHolder>() {
    private lateinit var listor: ArrayList<Model>

    var mref   : DatabaseReference?=null
    constructor( listor: ArrayList<Model>):this(){
        this.listor=listor
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartHolder {
        var cv = LayoutInflater.from(parent.context).inflate(R.layout.mycartlayout,parent,false)
        return CartHolder(cv)
    }

    override fun onBindViewHolder(holder: CartHolder, position: Int) {
        var order = listor.get(position)
        holder.getname1.text=order.name
        holder.price.text=order.price

    holder.btn.setOnClickListener {
        var database : FirebaseDatabase = FirebaseDatabase.getInstance()
        mref=database.getReference("authentication")
       mref?.child(order.id.toString())?.removeValue()
        Toast.makeText(it.context, "Deleted Successfully", Toast.LENGTH_SHORT).show()
        //holder.cv.setBackgroundColor(R.color.start)
      //  holder.cv.visibility=View.GONE
        

    }
    // holder.img.setImageResource(order.image!!)
    }

    override fun getItemCount(): Int {
return listor.size
    }
    inner class CartHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var getname1 = itemView.findViewById<TextView>(R.id.getname)
        var price = itemView.findViewById<TextView>(R.id.getprice)
        var btn = itemView.findViewById<Button>(R.id.deletefromcart)
        var con = itemView.findViewById<ConstraintLayout>(R.id.con)
        var cv = itemView.findViewById<CardView>(R.id.cv)

    }
}


