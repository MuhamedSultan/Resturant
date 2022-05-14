package com.example.register

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


class PizzaAdapter() : RecyclerView.Adapter<PizzaAdapter.MyViewHolderPizza>() {
    var mref   : DatabaseReference?=null

    private lateinit var pizzaName: Array<String>
    private lateinit var pizzaPrice: Array<String>
    private lateinit var pizzaimg: Array<Int>

    constructor(pizzaName: Array<String>, pizzaPrice: Array<String>, pizzaimg: Array<Int>) : this(){
        this.pizzaName=pizzaName
        this.pizzaPrice=pizzaPrice
        this.pizzaimg=pizzaimg
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderPizza {
        val cv = LayoutInflater.from(parent.context).inflate(R.layout.cardview_layout,parent,false)
        return MyViewHolderPizza(cv)
    }

    override fun onBindViewHolder(holder: MyViewHolderPizza, position: Int) {
        holder.names.setText(pizzaName[position])
        holder.prices.setText(pizzaPrice[position])
        holder.img.setImageResource(pizzaimg[position])
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
return pizzaName.size
    }
   inner class MyViewHolderPizza(itemView: View) : RecyclerView.ViewHolder(itemView) {
       var cv1 : View? = null
       var names=itemView.findViewById<TextView>(R.id.textView2)
       var prices=itemView.findViewById<TextView>(R.id.textView3)
       var img=itemView.findViewById<ImageView>(R.id.imageView)
       var cv = itemView.findViewById<CardView>(R.id.card)
       var add = itemView.findViewById<Button>(R.id.addtocart)


   }
}


