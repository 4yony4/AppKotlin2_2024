package com.example.appkotlin2.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.appkotlin2.R
import com.example.appkotlin2.singleton.DataHolder
import com.squareup.picasso.Picasso

/**
 * A simple [Fragment] subclass.
 * Use the [PerfilFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PerfilFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perfil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Log.d("PerfilFragment","-!!!!!!!! "+DataHolder.getInstance().positionSelected)
        val perfil=DataHolder.getInstance().arPerfiles[DataHolder.getInstance().positionSelected]

        val ivAvatar:ImageView=view.findViewById(R.id.ivAvatar)
        Picasso.get().load(perfil.avatar).into(ivAvatar)
    }
}