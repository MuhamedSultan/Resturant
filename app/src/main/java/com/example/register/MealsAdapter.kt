package com.example.register

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class MealsAdapter() : RecyclerView.Adapter<MealsAdapter.MyViewHolderMeals>() {
    var mref   : DatabaseReference?=null
    private lateinit var Mealsname: Array<String>
    private lateinit var Mealsprice: Array<String>
    private lateinit var  Mealsimg: Array<Int>
    constructor(Mealsname: Array<String>, Mealsprice: Array<String>, Mealsimg: Array<Int>) : this(){
        this.Mealsname=Mealsname
        this.Mealsprice=Mealsprice
        this.Mealsimg=Mealsimg
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderMeals {
       var cv = LayoutInflater.from(parent.context).inflate(R.layout.cardview_layout,parent,false)
        return MyViewHolderMeals(cv)
    }

    override fun onBindViewHolder(holder: MyViewHolderMeals, position: Int) {
        holder.names.setText(Mealsname[position])
        holder.prices.setText(Mealsprice[position])
        holder.img.setImageResource(Mealsimg[position])
        holder.add.setOnClickListener(View.OnClickListener {
            mref = FirebaseDatabase.getInstance().getReference("authentication")
            var name = holder.names.text.toString()
            var price = holder.prices.text.toString()
            var id = mref?.push()!!.key
            var order = Model(id, name, price)
            mref!!.child(id.toString()).setValue(order)
            Toast.makeText(it.context,"Added to Cart Successfully", Toast.LENGTH_SHORT).show()

        })
    }

    override fun getItemCount(): Int {
     return Mealsname.size
    }
    inner class MyViewHolderMeals(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var names=itemView.findViewById<TextView>(R.id.textView2)
        var prices=itemView.findViewById<TextView>(R.id.textView3)
        var img=itemView.findViewById<ImageView>(R.id.imageView)
        var cv = itemView.findViewById<CardView>(R.id.card)
        var add = itemView.findViewById<Button>(R.id.addtocart)

    }

}