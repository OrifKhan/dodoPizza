package com.example.dbfordodo.fragments

import android.icu.text.Transliterator.Position
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dbfordodo.R
import com.example.dbfordodo.databinding.FragmentComboBinding
import com.example.dbfordodo.db.data.Constants
import com.example.dbfordodo.dodoViewMadel.DodoViewMadel
import com.example.dbfordodo.dodoViewMadel.repository.DodoMadelFactory
import com.example.dbfordodo.view.ChangeAdapter
import com.example.dbfordodo.view.DataBaseApplication
import islom.din.dodo_ilmhona_proskills.db.data.Pizza
import kotlin.properties.Delegates

class ComboFragment : Fragment() {
    lateinit var adapter: ChangeAdapter
    lateinit var rcView: RecyclerView
    private var fragmentComboBinding: FragmentComboBinding? = null
    var indert=true
    var position: Int = 0
    private val args: ComboFragmentArgs by navArgs()
    private val dodoViewMadel: DodoViewMadel by activityViewModels {
        DodoMadelFactory((requireActivity().application as DataBaseApplication).database.pizzaDao(),
            (requireActivity().application as DataBaseApplication).database.orderDao())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_combo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = view.let { FragmentComboBinding.bind(it) }
        fragmentComboBinding = binding
        rcView = view.findViewById(R.id.recycleViewCombo)
        adapter = ChangeAdapter()
        rcView.adapter = adapter
        rcView.layoutManager = LinearLayoutManager(context)

        adapter.onClickItem = { pizza, pos ->

            val action = ComboFragmentDirections.actionComboFragmentToFragmetSelectPizza(
                pizza,
                pos
            )
            findNavController().navigate(action)
        }


        dodoViewMadel.getPizza().observe(viewLifecycleOwner) {
            position = args.pos - 1
            with(binding) {
                imageComboFragment.setImageResource(it[position].image)
                descriptionComboFragment.text = it[position].about
                nameCombo.text = it[position].name
            }


            dodoViewMadel.getCombo(it[position].id).observe(viewLifecycleOwner) {
                     adapter.submitList(it)
                     Log.d("sise", "${it.size}")

                }

            }


        }



    override fun onDestroyView() {
        fragmentComboBinding = null

        super.onDestroyView()
    }
}