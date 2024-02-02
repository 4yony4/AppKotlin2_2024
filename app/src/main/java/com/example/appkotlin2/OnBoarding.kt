package com.example.appkotlin2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.view.View.OnLongClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class OnBoarding : AppCompatActivity(),OnClickListener ,
OnLongClickListener{

    lateinit var buttonPasarPantalla:Button
    lateinit var btnCrearUser:Button

    lateinit var edTxtUser:EditText
    lateinit var edTxtPassword:EditText

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth

        setContentView(R.layout.activity_on_boarding)
        buttonPasarPantalla=findViewById(R.id.buttonPasarPantalla)
        btnCrearUser=findViewById(R.id.btnCrearUser)
        edTxtUser=findViewById(R.id.etxtUser)
        edTxtPassword=findViewById(R.id.edtxtPassword)

        buttonPasarPantalla.setOnClickListener(this)
        buttonPasarPantalla.setOnLongClickListener(this)
        btnCrearUser.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v!!.id==R.id.btnCrearUser){
            var email:String=edTxtUser.text.toString()
            var password:String=edTxtPassword.text.toString()
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("OnBoarding", "createUserWithEmail:success")
                        val user = auth.currentUser
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("OnBoarding", "createUserWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()
                    }
                }
        }
        else if(v!!.id==R.id.buttonPasarPantalla){
            var email:String=edTxtUser.text.toString()
            var password:String=edTxtPassword.text.toString()
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("OnBoarding", "signInWithEmail:success")
                        val user = auth.currentUser

                        var mainActivity:Intent = Intent(this,MainActivity::class.java)
                        startActivity(mainActivity)
                        finish()
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("OnBoarding", "signInWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()
                    }
                }
        }
    }

    override fun onLongClick(v: View?): Boolean {
        if(v!!.id==R.id.buttonPasarPantalla){

        }
        return true
    }
}