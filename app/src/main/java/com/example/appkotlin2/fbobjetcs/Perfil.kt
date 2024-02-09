package com.example.appkotlin2.fbobjetcs

class Perfil(datos: MutableMap<String, Any>){

    var nombre:String
    var apellidos:String
    var edad:Long=0
    var avatar:String
    var inclass:Boolean

    init {
        nombre=datos["nombre"] as String
        apellidos=datos["apellidos"] as String
        edad=datos["edad"] as Long //Integer.parseInt()
        avatar=datos["avatar"] as String
        inclass=datos["inclass"] as Boolean
    }

}