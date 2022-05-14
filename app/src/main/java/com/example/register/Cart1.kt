package com.example.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isEmpty
import androidx.recyclerview.widget.GridLayoutManager
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.activity_cart1.*
import kotlinx.android.synthetic.main.longclicklayout.*
import kotlinx.android.synthetic.main.longclicklayout.view.*

class Cart1 : AppCompatActivity() {
    var mref : DatabaseReference?=null
    var listor : ArrayList<Model>? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart1)

        var database: FirebaseDatabase = FirebaseDatabase.getInstance()
        mref = database.getReference("authentication")
        listor = ArrayList()

        list.setOnItemLongClickListener { parent, view, position, id ->
            var order = listor!!.get(position)
            val alertbuilder   = AlertDialog.Builder(this)
                val view = layoutInflater.inflate(R.layout.longclicklayout,null)
                alertbuilder.setView(view)
                val alertdialoge = alertbuilder.create()
                alertdialoge.show()

            view.deletefromcart1.setOnClickListener {
                mref?.child(order.id.toString())?.removeValue()
                alertdialoge.dismiss()
                Toast.makeText(it.context, "Deleted Successfully", Toast.LENGTH_SHORT).show()
            }

           view.cancle.setOnClickListener {
                alertdialoge.dismiss()
            }
         false
        }
    }

    override fun onStart() {
        super.onStart()
        mref!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                listor?.clear()
                for (or in snapshot.children) {
                    var getorder = or.getValue(Model::class.java)
                    listor?.add(getorder!!)
                }
                var adapter = AdapterList(applicationContext, listor!!)
                list.adapter = adapter

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
        floatingActionButton1.setOnClickListener {
            if (list.isEmpty()){
                Toast.makeText(this,"No product to make order",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Order done....",Toast.LENGTH_SHORT).show()
                list.visibility=View.GONE
            }
        }
    }

}

