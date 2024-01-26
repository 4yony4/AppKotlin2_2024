package com.example.appkotlin2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.view.View.OnLongClickListener
import android.widget.Button

class OnBoarding : AppCompatActivity(),OnClickListener ,
OnLongClickListener{

    lateinit var buttonPasarPantalla:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
        buttonPasarPantalla=findViewById(R.id.buttonPasarPantalla)
        buttonPasarPantalla.setOnClickListener(this)
        buttonPasarPantalla.setOnLongClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v!!.id==R.id.buttonPasarPantalla){
            var mainActivity:Intent = Intent(this,MainActivity::class.java)
            startActivity(mainActivity)
            finish()
        }
    }

    override fun onLongClick(v: View?): Boolean {
        if(v!!.id==R.id.buttonPasarPantalla){

        }
        return true
    }
}