package com.example.register

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_cart1.view.*
import kotlinx.android.synthetic.main.cart1layout.view.*

class AdapterList(context: Context,listor : ArrayList<Model>) : ArrayAdapter<Model>(context,0,listor) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val viwe =  LayoutInflater.from(context).inflate(R.layout.cart1layout,parent,false)
        val order : Model? = getItem(position)
        if (order != null) {
            viwe.name.text=order.name
           viwe.price.text=order.price
        }

        return viwe
    }
}