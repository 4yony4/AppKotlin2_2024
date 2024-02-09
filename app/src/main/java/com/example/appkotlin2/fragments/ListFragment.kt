package com.example.appkotlin2.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appkotlin2.R
import com.example.appkotlin2.adapters.List1Adapter
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {

    lateinit var rvLista1:RecyclerView
    val db = Firebase.firestore
    val TAG = "ListFragment"

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
        //val arNombres = arrayOf("Castanedo", "Martinez", "Guemes", "Roma")
        val arNombres = ArrayList<String>()
        db.collection("nombres")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    //Log.d(TAG, "${document.id} => ${document.data}")
                    arNombres.add(document.data["valor"].toString())
                }
                //Log.d(TAG, "111--------->>>>>>>>>>>> "+arNombres.size)
                rvLista1.adapter=List1Adapter(requireContext(),arNombres.toList())
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }
    }
}