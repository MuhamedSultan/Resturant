package com.example.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : AppCompatActivity() {
    var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        mAuth = FirebaseAuth.getInstance()

        btnRegister.setOnClickListener() {
            register()
        }

    }
    private fun register(){
        var email = edemail.text.toString()
        var password = edpassword.text.toString()

        if (email.isNotEmpty()&&password.isNotEmpty()){
            progressBar.visibility=View.VISIBLE
            mAuth?.createUserWithEmailAndPassword(email, password)?.
            addOnCompleteListener {
                if (it.isSuccessful){
                    progressBar.visibility=View.GONE
                    sendVerification()
                    Toast.makeText(applicationContext, "Successful", Toast.LENGTH_SHORT).show()

                }else{
                    progressBar.visibility=View.GONE

                    Toast.makeText(applicationContext, it.exception.toString(), Toast.LENGTH_SHORT).show()
                }

            }
        }else{
            Toast.makeText(applicationContext, "Email and password Required", Toast.LENGTH_SHORT).show()

        }

    }
    private fun sendVerification(){
        var user  = mAuth?.currentUser
        user?.sendEmailVerification()?.addOnCompleteListener {
            if (it.isSuccessful){
                var intent = Intent(this,LoginActivtiyy::class.java)
                startActivity(intent)
        }else{
                Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
            }

        }
    }
}