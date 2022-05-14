package com.example.register

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DrinksAdapter() :  RecyclerView.Adapter<DrinksAdapter.MyViewHolderDrinks>() {
    var mref   : DatabaseReference?=null
    private lateinit var Drinkssname: Array<String>
    private lateinit var Drinksprice: Array<String>
    private lateinit var Drinksimg: Array<Int>

    constructor(Drinkssname: Array<String>,Drinksprice : Array<String>, Drinksimg: Array<Int>) : this() {
        this.Drinkssname = Drinkssname
        this.Drinksprice = Drinksprice
        this.Drinksimg = Drinksimg
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderDrinks {
        val cv = LayoutInflater.from(parent.context).inflate(R.layout.cardview_layout,parent,false)
        return MyViewHolderDrinks(cv)
    }

    override fun onBindViewHolder(holder: MyViewHolderDrinks, position: Int) {
        holder.names.setText(Drinkssname[position])
        holder.prices.setText(Drinksprice[position])
        holder.img.setImageResource(Drinksimg[position])
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
        return Drinkssname.size
    }
    inner class MyViewHolderDrinks(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var names=itemView.findViewById<TextView>(R.id.textView2)
        var prices=itemView.findViewById<TextView>(R.id.textView3)
        var img=itemView.findViewById<ImageView>(R.id.imageView)
        var cv = itemView.findViewById<CardView>(R.id.card)
        var add = itemView.findViewById<Button>(R.id.addtocart)

    }
}