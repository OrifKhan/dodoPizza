package com.example.dbfordodo.fragments

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
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
import com.example.dbfordodo.view.DataBaseApplication
import com.google.android.material.chip.Chip
import islom.din.dodo_ilmhona_proskills.QA.adapter.InterestingAdapter
import islom.din.dodo_ilmhona_proskills.QA.adapter.PizzaAdapter

@Suppress("IMPLICIT_CAST_TO_ANY")
open class HomeFragment : Fragment() {
    //binding
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    //View Model
    private val dodoViewModel: DodoViewMadel by activityViewModels(){
        DodoMadelFactory(Application(),(requireActivity().application as DataBaseApplication).database.pizzaDao())
    }
//View Model
    private val viewModel: HomeViewModel by activityViewModels {
        HomeViewMadelFactory(Application(),(requireActivity().application as DataBaseApplication).database.pizzaDao())
}

    private val args : HomeFragmentArgs by navArgs()

    private lateinit var adapterForPizza: PizzaAdapter


        //Room View Model
        private val roomViewModel: RoomViewModel by activityViewModels {
            RoomViewModelFactory((requireActivity().application as DataBaseApplication).database.ingredientsDao(),
                (requireActivity().application as DataBaseApplication).database.ingredientProductsConnectionDao(),
                (requireActivity().application as DataBaseApplication).database.productsDao(),
                (requireActivity().application as DataBaseApplication).database.orderDao())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Room View Model
   //  dodoViewModel.insertViewMadel()




        // Making Bottom Nav View Visible
 /*var bottomNavigationView = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_nav_view)
       bottomNavigationView.setOnItemSelectedListener{
           when(it.itemId){
               -> {navigateToMeetFragment()
               if (!viewModel.hideBottomNavView) {
                   bottomNavigationView.visibility = View.VISIBLE
               }
               }
           }
           true
       }*//*

if (!viewModel.hideBottomNavView)
            bottomNavigationView.visibility = View.VISIBLE*/


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

   /* private fun navigateToMeetFragment() {
        val directions = HomeFragmentDirections.actionNavigationHomeToMeetFragment()
        findNavController().navigate(directions)
    }*/

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
            var checkedId = checkedIds.first()
            var checkedCategoryButton = requireActivity().findViewById<Chip>(checkedId)
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
                binding.naDostavku.setBackgroundResource(R.drawable.shape_chip_white)
                binding.vZale.setBackgroundResource(R.drawable.shape_chip_grey)
            }else if (viewModel.orderStreet.value == Constants.ZAL){
                binding.vZale.setBackgroundResource(R.drawable.shape_chip_white)
                binding.naDostavku.setBackgroundResource(R.drawable.shape_chip_grey)
            }
        }

            //What should happen if I click "V zale" button
        binding.vZale.setOnClickListener {
                viewModel.changeOrderType(Constants.ZAL)
            }

            //What should happen if I click "Dostavka" button
        binding.naDostavku.setOnClickListener {
                    viewModel.changeOrderType(Constants.DOSTAVKA)
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
            roomViewModel.newOrderConnection(Constants.USER_ID,it.id,1)
            Toast.makeText(requireContext(),"Added to busket",Toast.LENGTH_SHORT).show()
        }
        binding.pizzaRv.adapter = adapterForPizza
        adapterForPizza.onClick={pos,pizza->
            Toast.makeText(requireContext(),"$pos",Toast.LENGTH_SHORT).show()
            val action = if (pizza.category==Constants.COMBO) {
                HomeFragmentDirections.actionNavigationHomeToComboFragment(pos)
            }else{
               HomeFragmentDirections.actionNavigationHomeToFragmentViewPager(pos,pizza)


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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
