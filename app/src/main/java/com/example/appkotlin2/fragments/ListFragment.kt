package com.example.appkotlin2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appkotlin2.R
import com.example.appkotlin2.adapters.List1Adapter


/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {

    lateinit var rvLista1:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvLista1=view.findViewById(R.id.rvLista1)
        rvLista1.layoutManager=LinearLayoutManager(requireContext())
        //rvLista1.layoutManager = GridLayoutManager(context,3)
        val arNombres = arrayOf("Castanedo", "Martinez", "Guemes", "Roma")
        rvLista1.adapter=List1Adapter(requireContext(),arNombres)

    }
}