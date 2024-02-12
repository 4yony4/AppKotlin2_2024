package com.example.appkotlin2.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.appkotlin2.R
import com.example.appkotlin2.fbobjetcs.Perfil
import com.squareup.picasso.Picasso

class List1Adapter(var context:Context,
                   var arPerfiles:List<Perfil>,
                   var onItemClick: (position: Int) -> Unit):
    RecyclerView.Adapter<List1Item>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): List1Item {
        var viewXML:View = LayoutInflater.from(context).inflate(
            R.layout.itemlist1, parent, false)
        var list1Item:List1Item=List1Item(viewXML,onItemClick)
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
        holder.bind(perfilTemp,position)
    }
}

class List1Item(itemView: View,var onItemClick: (position: Int) -> Unit) : ViewHolder(itemView),OnClickListener {

    var tvItem1:TextView
    var ivImageItem1:ImageView
    var swItem1:Switch
    var pos:Int=0

    init {
        tvItem1=itemView.findViewById(R.id.tvItem1)
        ivImageItem1=itemView.findViewById(R.id.ivImageItem1)
        swItem1=itemView.findViewById(R.id.swItem1)
        itemView.setOnClickListener(this)
    }

    fun bind(perfil: Perfil,pos:Int){
        tvItem1.text=perfil.nombre+"  "+perfil.apellidos
        swItem1.isChecked=perfil.inclass
        Picasso.get().load(perfil.avatar).into(ivImageItem1)
        this.pos=pos
    }

    override fun onClick(v: View?) {
        //Log.d("List1Item","-------->>>>>>>>>   "+position)
        onItemClick(pos)
    }


}