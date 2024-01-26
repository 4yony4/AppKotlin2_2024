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

    lateinit var tvHolaMundo:TextView
    lateinit var rootConstrainLayout:ConstraintLayout
    lateinit var buttonOk:Button
    lateinit var buttonCancel:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.v("MainActivity","ENTRO EN CREAR")

        tvHolaMundo=this.findViewById(R.id.tvHolaMundo)
        rootConstrainLayout=this.findViewById(R.id.rootConstrainLayout)
        buttonOk = this.findViewById(R.id.buttonOk)
        buttonCancel= this.findViewById(R.id.buttonCancel)

        buttonOk.setOnClickListener(this)

        buttonCancel.setOnClickListener(this)


        /*Log.v("MainActivity","HOLA Q TAL!!!")
        Log.i("MainActivity","HOLA Q TAL!!!")
        Log.d("MainActivity","HOLA Q TAL!!!")
        Log.w("MainActivity","HOLA Q TAL!!!")
        Log.e("MainActivity","HOLA Q TAL!!!")*/

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
        if(v!!.id==R.id.buttonOk){
            Log.v("MainActivity","PRESIONE OK")
            tvHolaMundo.text="HASTA LUEGO MUNDO"
            rootConstrainLayout.setBackgroundColor(Color.MAGENTA)
        }
        else if(v!!.id==R.id.buttonCancel){
            tvHolaMundo.text="VOLVEMOS ATRAS"
            rootConstrainLayout.setBackgroundColor(Color.YELLOW)
        }
    }

}