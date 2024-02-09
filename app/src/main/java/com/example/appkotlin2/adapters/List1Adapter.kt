package com.example.appkotlin2.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.appkotlin2.R
import com.example.appkotlin2.fbobjetcs.Perfil
import com.squareup.picasso.Picasso

class List1Adapter(var context:Context,var arPerfiles:List<Perfil>):
    RecyclerView.Adapter<List1Item>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): List1Item {
        var viewXML:View = LayoutInflater.from(context).inflate(
            R.layout.itemlist1, parent, false)
        var list1Item:List1Item=List1Item(viewXML)
        Log.v("List1Adapter","HE ENTRADO EN onCreateViewHolder")
        return list1Item
    }

    override fun getItemCount(): Int {
        return arPerfiles.size
    }

    override fun onBindViewHolder(holder: List1Item, position: Int) {
        val perfilTemp:Perfil=arPerfiles[position]
        //holder.tvItem1.text=perfilTemp.nombre+"  "+perfilTemp.apellidos
        //holder.swItem1.isChecked=perfilTemp.inclass
        //Picasso.get().load(perfilTemp.avatar).into(holder.ivImageItem1)
        holder.bind(perfilTemp)
    }
}

class List1Item(itemView: View) : ViewHolder(itemView) {

    var tvItem1:TextView
    var ivImageItem1:ImageView
    var swItem1:Switch

    init {
        tvItem1=itemView.findViewById(R.id.tvItem1)
        ivImageItem1=itemView.findViewById(R.id.ivImageItem1)
        swItem1=itemView.findViewById(R.id.swItem1)
    }

    fun bind(perfil: Perfil){
        tvItem1.text=perfil.nombre+"  "+perfil.apellidos
        swItem1.isChecked=perfil.inclass
        Picasso.get().load(perfil.avatar).into(ivImageItem1)
    }


}