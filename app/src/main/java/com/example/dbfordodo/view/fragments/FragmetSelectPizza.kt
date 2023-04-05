package com.example.dbfordodo.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.example.dbfordodo.R
import com.example.dbfordodo.databinding.FragmentFragmetSelectPizzaBinding
import com.example.dbfordodo.dodoViewMadel.madelFactory.DodoMadelFactory
import com.example.dbfordodo.dodoViewMadel.viewModel.DodoViewMadel
import com.example.dbfordodo.madel.data.Constants
import com.example.dbfordodo.view.HelperClass.DataBaseApplication
import com.example.dbfordodo.view.HelperClass.HorizontalMarginItemDecoration
import com.example.dbfordodo.view.adapter.ViewPager.PagerPizzaAdpater


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
                (requireActivity().application as DataBaseApplication).database.pizzaDao(),
                (requireActivity().application as DataBaseApplication).database.orderDao()
            )
        }
        binding.viewPagerSelectPizza.adapter = adapter
        val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible1)
        val currentItemHorizontalMarginPx = resources.getDimension(/* id = */ R.dimen.viewpager_current_item_horizontal_margin1)
        val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
        val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->

            page.translationX = -pageTranslationX * position
            // Next line scales the item's height. You can remove it if you don't want this effect
            page.scaleY = 1 - (0.25f * Math.abs(position))
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


        dodoViewMadel.getComboPizza(args.pizza.id).observe(viewLifecycleOwner) {
            it.forEach() {
                Toast.makeText(requireContext(),"${it.id_combo}",Toast.LENGTH_SHORT).show()
            adapter.onSelectItem = { pizza ->
                    dodoViewMadel.updateComboPizza(args.pizza.id,  pizza.id)
                findNavController().navigateUp()
                }
            }




        /*Navigation.findNavController(view).popBackStack()*/

        }


        val category = args.pizza

        when (category.category) {
            Constants.PIZZA ->
                dodoViewMadel.getCategoryWithSize(Constants.PIZZA,2)
                    .observe(viewLifecycleOwner) { adapter.submitList(it) }
            Constants.NAPITKI ->
                dodoViewMadel.getCategoryWithSize(Constants.NAPITKI,2)
                    .observe(viewLifecycleOwner) { adapter.submitList(it) }
            Constants.SOUSI ->
                dodoViewMadel.getCategoryWithSize(Constants.SOUSI,2)
                    .observe(viewLifecycleOwner) { adapter.submitList(it) }
            Constants.ZAKUSKI ->
                dodoViewMadel.getCategoryWithSize(Constants.ZAKUSKI,2)
                    .observe(viewLifecycleOwner) { adapter.submitList(it) }
            Constants.DESERTI ->
                dodoViewMadel.getCategoryWithSize(Constants.DESERTI,2)
                    .observe(viewLifecycleOwner) { adapter.submitList(it) }
        }






        binding.root.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}