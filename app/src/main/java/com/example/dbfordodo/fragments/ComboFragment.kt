package com.example.dbfordodo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dbfordodo.R
import com.example.dbfordodo.databinding.FragmentComboBinding
import com.example.dbfordodo.dodoViewMadel.DodoViewMadel
import com.example.dbfordodo.view.ChangeAdapter

class ComboFragment : Fragment() {
    lateinit var adapter: ChangeAdapter
    lateinit var rcView: RecyclerView
    private var fragmentComboBinding: FragmentComboBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
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

        val viewModel = ViewModelProvider(requireActivity())[DodoViewMadel::class.java]

        viewModel.getPizza().observe(viewLifecycleOwner) { it ->
            it.forEach {

            binding.imageComboFragment.setImageResource(it.image)
            binding.descriptionComboFragment.text = it.about
            binding.nameCombo.text = it.name
        }}


        adapter.onClickItem = { pizza, pos ->

            val action = ComboFragmentDirections.actionComboFragmentToFragmetSelectPizza(pizza)
            findNavController().navigate(action)
        }

        viewModel.getPizza().observe(viewLifecycleOwner) { listOfPizza ->
            adapter.submitList(listOfPizza)
        }
    }

    override fun onDestroyView() {
        fragmentComboBinding = null
        super.onDestroyView()
    }
}