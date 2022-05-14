package com.example.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()  {
  //  var mAuth : FirebaseAuth?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     //   mAuth= FirebaseAuth.getInstance()
    }

//  override fun onStart() {
//        super.onStart()
//        if (mAuth?.currentUser == null){
//            var intentLogin = Intent(this,LoginActivtiyy ::class.java)
//            startActivity(intentLogin)
//
//        }
//
//    }
//
//    fun btn(view: android.view.View) {
//        var intentt = Intent(this,LoginActivtiyy::class.java)
//        startActivity(intentt)
//    }

}