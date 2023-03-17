package com.example.dbfordodo.fragments

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dbfordodo.R
import com.example.dbfordodo.databinding.FragmentFragmetSelectPizzaBinding
import com.example.dbfordodo.db.data.Constants
import com.example.dbfordodo.dodoViewMadel.DodoViewMadel
import com.example.dbfordodo.dodoViewMadel.repository.DodoMadelFactory
import com.example.dbfordodo.view.DataBaseApplication
import com.example.dbfordodo.view.ViewPager.PagerPizzaAdpater
import islom.din.dodo_ilmhona_proskills.db.data.Pizza


class FragmetSelectPizza : Fragment() {
    var adapter = PagerPizzaAdpater()

    var list = mutableListOf<Pizza>()
    //FragmentSelectPizzaArgs
    private val args: FragmetSelectPizzaArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragmet_select_pizza, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = view.let { FragmentFragmetSelectPizzaBinding.bind(it) }

      val dodoViewMadel : DodoViewMadel by activityViewModels {
            DodoMadelFactory(Application(),(requireActivity().application as DataBaseApplication).database.pizzaDao())
        }
       binding.recyaclePager.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.recyaclePager.adapter = adapter
         adapter.list=args.listOfPizza.toMutableList()


      adapter.onSelectItem = {
      val action=FragmetSelectPizzaDirections.actionFragmetSelectPizzaToComboFragment(it.id)
      findNavController().navigate(action)
      /*  viewModel.pizzaChanged(it)
            (requireActivity().supportFragmentManager.findFragmentById(R.id.fragmetSelectPizza) as NavHostFragment)
                .navController.navigateUp()*/
        }


        val category = args.pizza

        when(category.category) {
            Constants.PIZZA ->
                dodoViewMadel.getCategory(Constants.PIZZA).observe(viewLifecycleOwner){it.forEach { list.add(it) }}
            Constants.NAPITKI ->
                dodoViewMadel.getCategory(Constants.NAPITKI).observe(viewLifecycleOwner){ it.forEach { list.add(it) }}
            Constants.SOUSI ->
                dodoViewMadel.getCategory(Constants.SOUSI).observe(viewLifecycleOwner){ it.forEach { list.add(it) }}
            Constants.ZAKUSKI ->
                dodoViewMadel.getCategory(Constants.ZAKUSKI).observe(viewLifecycleOwner){ it.forEach { list.add(it) }}
            Constants.DESERTI ->
                dodoViewMadel.getCategory(Constants.DESERTI).observe(viewLifecycleOwner){ it.forEach { list.add(it) }}
        }
        dodoViewMadel.getChoicePizza(40,2).observe(viewLifecycleOwner){it.forEach { list.add(it) }}



        adapter.submitList(list)

        binding.root.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}