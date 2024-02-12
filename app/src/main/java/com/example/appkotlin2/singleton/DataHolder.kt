package com.example.appkotlin2.singleton

import com.example.appkotlin2.fbobjetcs.Perfil

class DataHolder {

    var positionSelected:Int=0
    lateinit var arPerfiles:ArrayList<Perfil>


    companion object {
        private var instance: DataHolder?=null
        fun getInstance(): DataHolder {
            if(instance ==null) instance = DataHolder()
            return instance!!
        }
    }
}