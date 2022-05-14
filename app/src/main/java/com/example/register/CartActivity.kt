package com.example.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateFormat
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.mycartlayout.*

class CartActivity : AppCompatActivity() {
var mref : DatabaseReference ?=null
var listor : ArrayList<Model>? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        var database: FirebaseDatabase = FirebaseDatabase.getInstance()
        mref = database.getReference("authentication")
        listor = ArrayList()


            mref!!.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    listor!!.clear()
                    for (or in snapshot.children) {
                        var getorder = or.getValue(Model::class.java)
                        listor?.add(getorder!!)
                    }
                    var cart = CartAdapter(listor!!)
                    MyCartRecy.adapter = cart
                    var mang = GridLayoutManager(this@CartActivity, 1)
                    MyCartRecy.layoutManager = mang

                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })


    }


}
