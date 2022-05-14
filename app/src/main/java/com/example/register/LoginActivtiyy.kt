package com.example.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login_activtiy.*
import java.util.*

class LoginActivtiyy : AppCompatActivity() {

    var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_activtiy)
        mAuth = FirebaseAuth.getInstance()

        signup.setOnClickListener() {
            var signupIntent = Intent(this, SignUp::class.java)
            startActivity(signupIntent)
        }

        btn_login.setOnClickListener {

            var Email = edloginemail.text.toString()
            var password = edloginpass.text.toString()
            if (Email.isNotEmpty() && password.isNotEmpty()) {

                mAuth?.signInWithEmailAndPassword(Email, password)?.addOnCompleteListener {
                    if (it.isSuccessful) {
                       verifyEmail()
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                    }
                }

            }else{
                Toast.makeText(this, "invalid Email or password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun verifyEmail() {
        var user: FirebaseUser? = mAuth?.currentUser
        if (user!!.isEmailVerified){
            var intent = Intent(this, StartActivity::class.java)
            startActivity(intent)
        }else
            Toast.makeText(this, "Please veriyfy Email Adress", Toast.LENGTH_SHORT).show()
    }

}







