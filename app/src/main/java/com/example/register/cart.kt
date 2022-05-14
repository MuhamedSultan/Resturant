package com.example.register

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.getcard_layout.view.*

class Cart(context: Context,orderlist : ArrayList<Model>):

    ArrayAdapter<Model>(context  ,0,orderlist) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return super.getView(position, convertView, parent)
        val view =
            LayoutInflater.from(context).inflate(R.layout.getcard_layout, parent, false)
        val order: Model? = getItem(position)
        if (order != null) {
        //    view.imageView1.setImageResource(order.image!!)
            view.textprice.text = order.price
            view.textname.text = order.name
        }
        return view
    }
}
