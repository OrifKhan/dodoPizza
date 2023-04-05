package com.example.dbfordodo.view.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.dbfordodo.R
import com.example.dbfordodo.databinding.FragmentContactBinding

class ContactFragment : Fragment() {
    private lateinit var binding: FragmentContactBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContactBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

       /* binding.textDocumentetion.setOnClickListener {
            val navController = findNavController()
            navController.navigate(R.id.documentFragment)
            *//*val action=ContactFragmentDirections.actionContactFragmentToDocumentFragment()
            findNavController().navigate(action)*//*
        }*/
        binding.openMap.setOnClickListener {
            val navController = findNavController()
            navController.navigate(R.id.action_navigation_contact_to_mapsFragment)
        }

        binding.call.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:944000004")
            startActivity(intent)
        }

       binding.goToAboutFragment.setOnClickListener {
            val navController = findNavController()
            navController.navigate(R.id.action_contactFragment_to_aboutFragment)
        }
        val DocumentFragment = view.findViewById<LinearLayout>(R.id.linear1)
        DocumentFragment.setOnClickListener {
            Log.d("document", "documentFragment go!!")
            val navController = findNavController()
            navController.navigate(R.id.documentFragment)
        }

        binding.instagram.setOnClickListener {
            val intent =  Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/dodopizza.tj?igshid=YmMyMTA2M2Y="))
            startActivity(intent)
        }

        binding.facebook.setOnClickListener {
            val intent =  Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/dodopizza/?locale=ru_RU"))
            startActivity(intent)
        }
    }
}