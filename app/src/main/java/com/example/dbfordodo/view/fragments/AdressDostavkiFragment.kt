package com.example.dbfordodo.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.dbfordodo.databinding.FragmentAdressDostavkiBinding
import com.example.dbfordodo.dodoViewMadel.viewModel.HomeViewModel


class AdressDostavkiFragment : Fragment() {

    private var _binding : FragmentAdressDostavkiBinding? = null
    private val binding get() = _binding!!

    //View Model
    private val viewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAdressDostavkiBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       /* binding.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.save ->  {
                    val action =
                       AdressDostavkiFragmentDirections.actionAdressDostavkiFragment2ToNavigationHome(
                            binding.ulica.toString(),
                            null
                        )
                    findNavController().navigate(action)
                    return@setOnMenuItemClickListener true
                }
                R.id.back->{

                    Navigation.findNavController(view).popBackStack()
                }
                else -> {true}
            }
        }*/
    }


}