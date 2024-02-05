package com.example.appkotlin2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity(),OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.v("MainActivity","ENTRO EN CREAR")


    }

    override fun onPause() {
        super.onPause()
        Log.v("MainActivity","ENTRO EN PAUSA")
    }

    override fun onResume() {
        super.onResume()
        Log.v("MainActivity","ENTRO EN RESUME")
    }

    override fun onClick(v: View?) {
    }

}