package com.example.dbfordodo.fragments

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.example.dbfordodo.R
import com.example.dbfordodo.databinding.FragmentFragmetSelectPizzaBinding
import com.example.dbfordodo.db.data.Combo
import com.example.dbfordodo.db.data.Constants
import com.example.dbfordodo.dodoViewMadel.DodoViewMadel
import com.example.dbfordodo.dodoViewMadel.repository.DodoMadelFactory
import com.example.dbfordodo.view.DataBaseApplication
import com.example.dbfordodo.view.ViewPager.PagerPizzaAdpater
import com.example.order.view.HorizontalMarginItemDecoration


class FragmetSelectPizza : Fragment() {
    var adapter = PagerPizzaAdpater()


    //FragmentSelectPizzaArgs
    private val args: FragmetSelectPizzaArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragmet_select_pizza, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = view.let { FragmentFragmetSelectPizzaBinding.bind(it) }

        val dodoViewMadel: DodoViewMadel by activityViewModels {
            DodoMadelFactory(
                Application(),
                (requireActivity().application as DataBaseApplication).database.pizzaDao()
            )
        }
        binding.viewPagerSelectPizza.adapter = adapter
        adapter.idSelectPizza = args.pizza.id
        binding.viewPagerSelectPizza.offscreenPageLimit=1
        val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible1)
        val currentItemHorizontalMarginPx = resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin1)
        val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
        val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
            page.translationX = -pageTranslationX * position
            // Next line scales the item's height. You can remove it if you don't want this effect
            page.scaleY = 1 - (0.1f * Math.abs(position))
            // If you want a fading effect uncomment the next line:
        }
            binding.viewPagerSelectPizza.setPageTransformer(pageTransformer)

// The ItemDecoration gives the current (centered) item horizontal margin so that
// it doesn't occupy the whole screen width. Without it the items overlap
            val itemDecoration = HorizontalMarginItemDecoration(
                requireContext(),
                R.dimen.viewpager_current_item_horizontal_margin
            )
            binding.viewPagerSelectPizza.addItemDecoration(itemDecoration)



            adapter.onSelectItem = { pizza ->
            dodoViewMadel.getComboPizza(args.pizza.id).observe(viewLifecycleOwner) {
                it.forEach() {
                    dodoViewMadel.updateComboPizza(Combo(args.pizza.id, it.id_combo, pizza.id))
                    Log.d("listzise", "$it")
                }
            }
            findNavController().navigateUp()
            /*Navigation.findNavController(view).popBackStack()*/
            /*  viewModel.pizzaChanged(it)
                  (requireActivity().supportFragmentManager.findFragmentById(R.id.fragmetSelectPizza) as NavHostFragment)
                      .navController.navigateUp()*/
        }


        val category = args.pizza

        when (category.category) {
            Constants.PIZZA ->
                dodoViewMadel.getCategory(Constants.PIZZA)
                    .observe(viewLifecycleOwner) { adapter.submitList(it) }
            Constants.NAPITKI ->
                dodoViewMadel.getCategory(Constants.NAPITKI)
                    .observe(viewLifecycleOwner) { adapter.submitList(it) }
            Constants.SOUSI ->
                dodoViewMadel.getCategory(Constants.SOUSI)
                    .observe(viewLifecycleOwner) { adapter.submitList(it) }
            Constants.ZAKUSKI ->
                dodoViewMadel.getCategory(Constants.ZAKUSKI)
                    .observe(viewLifecycleOwner) { adapter.submitList(it) }
            Constants.DESERTI ->
                dodoViewMadel.getCategory(Constants.DESERTI)
                    .observe(viewLifecycleOwner) { adapter.submitList(it) }
        }






        binding.root.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}