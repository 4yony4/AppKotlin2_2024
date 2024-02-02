package com.example.appkotlin2.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.appkotlin2.MainActivity
import com.example.appkotlin2.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment(), OnClickListener {

    lateinit var edtEmail: EditText
    lateinit var edtPassword: EditText
    lateinit var btnLogin: Button
    lateinit var btnRegister: Button
    private lateinit var auth: FirebaseAuth
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        auth = Firebase.auth
        navController=findNavController()
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        edtEmail = view.findViewById(R.id.edtEmail)
        edtPassword = view.findViewById(R.id.edtPassword)
        btnLogin = view.findViewById(R.id.btnLogin)
        btnRegister = view.findViewById(R.id.btnRegister)

        btnLogin.setOnClickListener(this)
        btnRegister.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v!!.id == R.id.btnLogin) {
            val sEmail = edtEmail.text.toString()
            val sPassword = edtPassword.text.toString()
            auth.signInWithEmailAndPassword(sEmail, sPassword)
                .addOnCompleteListener(requireActivity()) { task ->

                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        var mainActivity: Intent = Intent(requireActivity(), MainActivity::class.java)
                        startActivity(mainActivity)
                        requireActivity().finish()
                    } else {
                        // If sign in fails, display a message to the user.

                    }
                }
        } else if (v!!.id == R.id.btnRegister) {
            navController.navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

}