package com.example.register

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class PastaAdapter() : RecyclerView.Adapter<PastaAdapter.MyViewHolderPasta>() {
    var mref   : DatabaseReference?=null
    private lateinit var pastaName: Array<String>
    private lateinit var pastaPrice: Array<String>
    private lateinit var pastaimg: Array<Int>
    constructor(pastaName: Array<String>, pastaPrice: Array<String>, pastaimg: Array<Int>):this(){
        this.pastaName=pastaName
        this.pastaPrice=pastaPrice
        this.pastaimg=pastaimg
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PastaAdapter.MyViewHolderPasta {
        val cv = LayoutInflater.from(parent.context).inflate(R.layout.cardview_layout,parent,false)
        return MyViewHolderPasta(cv)
    }

    override fun onBindViewHolder(holder: PastaAdapter.MyViewHolderPasta, position: Int) {
        holder.names.setText(pastaName[position])
        holder.prices.setText(pastaPrice[position])
        holder.img.setImageResource(pastaimg[position])
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
       return pastaName.size
    }
    inner  class MyViewHolderPasta(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var names=itemView.findViewById<TextView>(R.id.textView2)
        var prices=itemView.findViewById<TextView>(R.id.textView3)
        var img=itemView.findViewById<ImageView>(R.id.imageView)
        var cv = itemView.findViewById<CardView>(R.id.card)
        var add = itemView.findViewById<Button>(R.id.addtocart)

    }
}