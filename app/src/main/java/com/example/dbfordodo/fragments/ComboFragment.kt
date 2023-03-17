package com.example.dbfordodo.fragments

import android.icu.text.Transliterator.Position
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dbfordodo.R
import com.example.dbfordodo.databinding.FragmentComboBinding
import com.example.dbfordodo.db.data.Constants
import com.example.dbfordodo.dodoViewMadel.DodoViewMadel
import com.example.dbfordodo.view.ChangeAdapter
import islom.din.dodo_ilmhona_proskills.db.data.Pizza
import kotlin.properties.Delegates

class ComboFragment : Fragment() {
    lateinit var adapter: ChangeAdapter
    lateinit var rcView: RecyclerView
    private var fragmentComboBinding: FragmentComboBinding? = null
    private  var combo= mutableListOf<Pizza>()
     var position: Int =0
    private val args: ComboFragmentArgs by navArgs()

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
        adapter.list=combo
        adapter.onClickItem = { pizza,pos,combo->

            val action = ComboFragmentDirections.actionComboFragmentToFragmetSelectPizza(pizza,combo.toTypedArray(),pos)
            findNavController().navigate(action)
        }
        val viewModel = ViewModelProvider(requireActivity())[DodoViewMadel::class.java]

        viewModel.getPizza().observe(viewLifecycleOwner) {
     position=args.pos-1
            with(binding) {
                imageComboFragment.setImageResource(it[position].image)
                descriptionComboFragment.text = it[position].about
                nameCombo.text = it[position].name
            }



            when (it[position].name) {
                "3 пиццы" -> {
                    viewModel.getChoicePizza(7, 2).observe(viewLifecycleOwner) { listOfPizza ->
                        listOfPizza.forEach {
                            combo.add(it)
                        }
                        adapter.submitList(combo)
                    }
                }
                "10 средних пицц" -> {
                    viewModel.getChoicePizza(22, 2).observe(viewLifecycleOwner) { listOfPizza ->
                        listOfPizza.forEach {
                            combo.add(it)
                        }
                        adapter.submitList(combo)
                    }
                }
                "2 пиццы" -> {
                    viewModel.getChoicePizza(5, 2).observe(viewLifecycleOwner) { listOfPizza ->
                        listOfPizza.forEach {
                            combo.add(it)
                        }
                        adapter.submitList(combo)
                    }
                }
                "7 пицц" -> {
                    viewModel.getChoicePizza(16, 2).observe(viewLifecycleOwner) { listOfPizza ->
                        listOfPizza.forEach {
                            combo.add(it)
                        }
                        adapter.submitList(combo)
                    }
                }
                "2 пиццы и напиток" -> {
                    viewModel.getChoicePizza(6, 2).observe(viewLifecycleOwner) { listOfPizza ->

                        listOfPizza.forEach {
                            combo.add(it)
                        }
                        viewModel.getCategory(Constants.NAPITKI).observe(viewLifecycleOwner) {
                            var cont = 0
                            it.forEach {
                                if (cont < 1)
                                    combo.add(it)
                                cont++
                            }
                        }
                        adapter.submitList(combo)
                    }
                }
                "Пицца и 2 закуски" -> {
                    viewModel.getChoicePizza(3, 2).observe(viewLifecycleOwner) {

                        it.forEach {
                            combo.add(it)
                        }
                        viewModel.getCategory(Constants.ZAKUSKI).observe(viewLifecycleOwner) {
                            var cont = 0
                            it.forEach {
                                if (cont < 2) {
                                    combo.add(it)
                                    cont++
                                }
                            }
                        }
                        adapter.submitList(combo)

                    }
                }
                "4 Додстера" -> {
                    viewModel.getCategory(Constants.DESERTI).observe(viewLifecycleOwner) {

                        var cont = 0
                        it.forEach {
                            if (cont < 4) {
                                combo.add(it)
                                cont++
                            }
                        }

                        adapter.submitList(combo)
                    }
                }
                "Пицца, додстер, напиток и соус" -> {

                    viewModel.getCategory(Constants.PIZZA).observe(viewLifecycleOwner) {
                        var cont = 0
                        it.forEach {
                            if (cont< 1) {
                                combo.add(it)
                                cont++
                            }
                        }
                    }
                    viewModel.getCategory(Constants.DESERTI).observe(viewLifecycleOwner) {
                        var cont = 0
                        it.forEach {
                            if (cont < 1) {
                                combo.add(it)
                                cont++
                            }
                        }
                    }
                    viewModel.getCategory(Constants.NAPITKI).observe(viewLifecycleOwner) {
                        var cont = 0
                        it.forEach {
                            if (cont < 1) {
                                combo.add(it)
                                cont++
                            }
                        }
                    }
                    viewModel.getCategory(Constants.ZAKUSKI).observe(viewLifecycleOwner) {
                        var cont = 0
                        it.forEach {
                            if (cont < 1) {
                                combo.add(it)
                                cont++
                            }
                        }
adapter.submitList(combo)
                    }
                }
                "2 стартера"->{

                    viewModel.getCategory(Constants.ZAKUSKI).observe(viewLifecycleOwner){
                        var cont =0
                        it.forEach {
                            if (cont<2){
                                combo.add(it)
                                cont++
                            }
                        }
                    adapter.submitList(combo)
                    }
                }
            }


        }

    }

    override fun onDestroyView() {
        fragmentComboBinding = null
        super.onDestroyView()
    }
}