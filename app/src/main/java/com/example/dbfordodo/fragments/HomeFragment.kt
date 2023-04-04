package com.example.dbfordodo.fragments

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dbfordodo.R
import com.example.dbfordodo.databinding.ChipItemBinding
import com.example.dbfordodo.databinding.FragmentHomeBinding
import com.example.dbfordodo.db.data.Constants
import com.example.dbfordodo.dodoViewMadel.DodoViewMadel
import com.example.dbfordodo.dodoViewMadel.HomeViewModel
import com.example.dbfordodo.dodoViewMadel.repository.DodoMadelFactory
import com.example.dbfordodo.dodoViewMadel.repository.HomeViewMadelFactory
import com.example.dbfordodo.dodoViewMadel.repository.RoomViewModel
import com.example.dbfordodo.dodoViewMadel.repository.RoomViewModelFactory
import com.example.dbfordodo.view.AdepterSores
import com.example.dbfordodo.view.DataBaseApplication
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.chip.Chip
import islom.din.dodo_ilmhona_proskills.QA.adapter.InterestingAdapter
import islom.din.dodo_ilmhona_proskills.QA.adapter.PizzaAdapter
import islom.din.dodo_ilmhona_proskills.db.data.Pizza
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


open class HomeFragment : Fragment() {
    //binding
    private lateinit var recyclerView: RecyclerView
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    //View Model
    private val dodoViewModel: DodoViewMadel by viewModels() {
        DodoMadelFactory(
            (requireActivity().application as DataBaseApplication).database.pizzaDao(),
            (requireActivity().application as DataBaseApplication).database.orderDao()
        )
    }

    //View Model
    private val viewModel: HomeViewModel by activityViewModels {
        HomeViewMadelFactory((requireActivity().application as DataBaseApplication).database.pizzaDao())
    }


    private lateinit var adapterForPizza: PizzaAdapter
    private lateinit var adapterStores: AdepterSores


    //Room View Model
    private val roomViewModel: RoomViewModel by activityViewModels {
        RoomViewModelFactory(
            (requireActivity().application as DataBaseApplication).database.ingredientsDao(),
            (requireActivity().application as DataBaseApplication).database.ingredientProductsConnectionDao(),
            (requireActivity().application as DataBaseApplication).database.productsDao(),
            (requireActivity().application as DataBaseApplication).database.orderDao()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomNavigationView =
            requireActivity().findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        bottomNavigationView.setOnItemSelectedListener() {

            if (sharedPref().getInt("number", 0) == null) {
                findNavController().navigate(R.id.action_navigation_home_to_profilFragement)
            } else {

                findNavController().navigate(R.id.action_navigation_home_to_meetFragment2)
            }

            true
            /*
            when (it.itemId) {
                }
                R.id.backFragment -> {
                    findNavController().navigate(R.id.action_navigation_home_to_korzinaFragment)
                    true
                }
                R.id.navigation_contact -> {
                    findNavController().navigate(R.id.action_navigation_home_to_korzinaFragment)
                    true
                }
                else->{
                    findNavController().navigate(R.id.navigation_home)
                    true
                }*/


        }

        adapterStores = AdepterSores()
        recyclerView = binding.recStoirs
        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapterStores
        adapterStores.itemOnClick = {
            val action = HomeFragmentDirections.actionNavigationHomeToStoresFragment(it)
            findNavController().navigate(action)
        }
        lifecycleScope.launch {
            delay(500)
            dodoViewModel.getMaineStores(true).observe(viewLifecycleOwner) {
                adapterStores.submitList(it)
                Log.d("Storis", "${it.size}")
            }
        }


        adapterForPizza = PizzaAdapter()


        setupChip()
        scrollingOnCategoryClicked()
        chooseOrderType()
        scrollingChangeListener()
        settingPizzaRecyclerView()
        setupInterestingRecyclerView()
    }

    private fun setupInterestingRecyclerView() {
        val adapter = InterestingAdapter()
        dodoViewModel.getAllSizeNormal(2).observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        binding.interestingRV.adapter = adapter
    }


    private fun scrollingChangeListener() {
        binding.pizzaRv.setOnScrollChangeListener { v, _, _, _, _ ->
            val pos =
                (binding.pizzaRv.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

            val currentList = adapterForPizza.currentList

            if (currentList[pos].category == Constants.PIZZA) {
                val chipsIndex = getIndexOfThisChip(currentList[pos].category)
                val chip = binding.chipCategoryGroup[chipsIndex]
                binding.chipCategoryGroup.check(chip.id)
            } else {
                if (currentList[pos].category != currentList[pos - 1].category ||
                    currentList[pos].category != currentList[pos + 1].category
                ) {
                    val chipsIndex =
                        getIndexOfThisChip(adapterForPizza.currentList[pos].category)
                    val chip = binding.chipCategoryGroup[chipsIndex]
                    binding.chipCategoryGroup.check(chip.id)
                }
            }
        }
    }

    private fun scrollingOnCategoryClicked() {
        binding.chipCategoryGroup.setOnCheckedStateChangeListener { group, checkedIds ->
            val checkedId = checkedIds.first()
            val checkedCategoryButton = requireActivity().findViewById<Chip>(checkedId)
            checkedCategoryButton.setOnClickListener {
                binding.pizzaRv.smoothScrollToPosition(adapterForPizza.currentList.indexOfFirst {
                    it.category == checkedCategoryButton.text
                } + 1)
                //Expands App Bar layout
                if (checkedCategoryButton.text == Constants.PIZZA)
                    binding.mainAppBar.setExpanded(true)
                else binding.mainAppBar.setExpanded(false)

                scrollingChangeListener()
            }
        }
    }

    private fun chooseOrderType() {
        viewModel.orderStreet.observe(requireActivity()) {
            if (viewModel.orderStreet.value == Constants.DOSTAVKA) {
                binding.adressDostavkiFragment.setBackgroundResource(R.drawable.shape_chip_white)
                binding.zalFragment2.setBackgroundResource(R.drawable.shape_chip_grey)
            } else if (viewModel.orderStreet.value == Constants.ZAL) {
                binding.zalFragment2.setBackgroundResource(R.drawable.shape_chip_white)
                binding.adressDostavkiFragment.setBackgroundResource(R.drawable.shape_chip_grey)
            }
        }

        //What should happen if I click "V zale" button
        binding.zalFragment2.setOnClickListener {
            viewModel.changeOrderType(Constants.ZAL)
            val action = HomeFragmentDirections.actionNavigationHomeToZalFragment()
            findNavController().navigate(action)
        }

        //What should happen if I click "Dostavka" button
        binding.adressDostavkiFragment.setOnClickListener {
            viewModel.changeOrderType(Constants.DOSTAVKA)
            val action = HomeFragmentDirections.actionNavigationHomeToAdressDostavkiFragment2()
            findNavController().navigate(action)
        }
    }

    private fun settingPizzaRecyclerView() {
        // Pizza recycler view initialising and setting adapter and list for it
        dodoViewModel.getAllSizeNormal(2).observe(viewLifecycleOwner) {
            adapterForPizza.submitList(it)
        }


//        Adding Pizzas to DB on price clicking
//        adapterForPizza.order = { orderedPizza ->
//            roomViewModel.insertProducts(orderedPizza)
//            Toast.makeText(requireContext(),"Added to db",Toast.LENGTH_SHORT).show()
//        }
        adapterForPizza.order = {
            Log.d("MYTESTINGERROR", "$it")
            roomViewModel.newOrderConnection(Constants.USER_ID, it.id, 1)
            Toast.makeText(requireContext(), "Added to busket", Toast.LENGTH_SHORT).show()
        }
        binding.pizzaRv.adapter = adapterForPizza
        adapterForPizza.onClick = { pos, pizza ->
            Toast.makeText(requireContext(), "$pos", Toast.LENGTH_SHORT).show()
            val action = if (pizza.category == Constants.COMBO) {
                HomeFragmentDirections.actionNavigationHomeToComboFragment(pos)
            } else {
                HomeFragmentDirections.actionNavigationHomeToFragmentViewPager(pos, pizza)


            }
            findNavController().navigate(action)
        }
    }

    private fun getIndexOfThisChip(category: String): Int {
        for (categoriesIndex in viewModel.categoryList.indices)
            if (category == viewModel.categoryList[categoriesIndex])
                return categoriesIndex
        return 0
    }

    private fun setupChip() {
        for (name in viewModel.categoryList) {
            val chip = createChip(name)
            binding.chipCategoryGroup.addView(chip)
            if (name == Constants.PIZZA)
                binding.chipCategoryGroup.check(chip.id)
        }
    }

    private fun createChip(category: String): Chip {
        val chip = ChipItemBinding.inflate(layoutInflater).root
        chip.text = category
        return chip
    }

    fun sharedPref(): SharedPreferences {
        return requireActivity().getSharedPreferences("number_user", Context.MODE_PRIVATE)
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
