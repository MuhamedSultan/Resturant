package com.example.register

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OrderAdapter() : RecyclerView.Adapter<OrderAdapter.MyCartHolder>() {
    private lateinit var orderlist: ArrayList<Model>

//    constructor(context: Context, orderlist: ArrayList<Model>) : this() {
//
//    }
    constructor(orderList: ArrayList<Model>):this(){

        this.orderlist = orderList
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCartHolder {
        val cv = LayoutInflater.from(parent.context).inflate(R.layout.getcard_layout, parent, false)
        return MyCartHolder(cv)
    }

    override fun onBindViewHolder(holder: MyCartHolder, position: Int) {
        var ordercart = orderlist.get(position)
        holder.textnames.setText(ordercart.name)
        holder.textprice.text = ordercart.price
        holder.img.setImageResource(ordercart.image!!)
    }


    override fun getItemCount(): Int {
        return orderlist!!.size
    }

    inner class MyCartHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textnames = itemView.findViewById<TextView>(R.id.textname)
        var textprice = itemView.findViewById<TextView>(R.id.textprice)
        var img = itemView.findViewById<ImageView>(R.id.imageView1)
    }

}

//    ArrayAdapter<Model>(context ,0,orderlist) {
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//        return super.getView(position, convertView, parent)
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.getcard_layout,parent,false)
//        val order : Model? =getItem(position)
//        if (order!= null){
//            view.imageView1.setImageResource(order.image!!)
//            view.textprice.text=order.price
//            view.textname.text=order.name
//        }
//        return view
//    }
