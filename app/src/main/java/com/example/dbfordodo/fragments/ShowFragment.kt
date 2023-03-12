package com.example.dbfordodo.fragments

import android.app.Application
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StrikethroughSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.contains
import androidx.core.view.isGone
import androidx.core.view.size
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.example.dbfordodo.R
import com.example.dbfordodo.databinding.ChipItemBinding
import com.example.dbfordodo.databinding.ChipTextItemBinding
import com.example.dbfordodo.databinding.DeleteIngridientItemBinding
import com.example.dbfordodo.databinding.ViewShowFragmentBinding
import com.example.dbfordodo.db.data.Constants
import com.example.dbfordodo.dodoViewMadel.DodoViewMadel
import com.example.dbfordodo.dodoViewMadel.repository.DodoMadelFactory
import com.example.dbfordodo.view.DataBaseApplication
import com.example.dbfordodo.view.ListSousAdapter
import com.google.android.material.chip.Chip
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import islom.din.dodo_ilmhona_proskills.db.data.Pizza
import islom.din.dodo_ilmhona_proskills.db.data.Vkus


private const val ARG_PARAM1: String = "param1"


class ShowFragment : Fragment() {

    private var _pizza : Pizza? = null
    private val pizza get() = _pizza!!

    lateinit var view:DeleteIngridientItemBinding
    lateinit var observerPizza: Observer<Pizza>

  //  private var ingridientList:MutableList<Pizza> = mutableListOf()
    //lateinit var catrgoty:Constants
    private var _binding: ViewShowFragmentBinding? = null
    lateinit var recycler: RecyclerView
    lateinit var adapter: ListSousAdapter
  // private var pizza= mutableListOf<Any>()
    private val dodoViewMadel: DodoViewMadel by activityViewModels {
        DodoMadelFactory(Application(),(requireActivity().application as DataBaseApplication).database.pizzaDao())
    }

    val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            _pizza = it.getParcelable(ARG_PARAM1)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        this._binding = ViewShowFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = view.let { ViewShowFragmentBinding.bind(it) }


        when (pizza.category) {
            Constants.PIZZA -> {
                binding.removeIngrelienites.setOnClickListener {
                    val view = setupChip(pizza)
                    MaterialAlertDialogBuilder(requireContext())
                        .setPositiveButton("DONE") { dialog, which: Int ->
                            dodoViewMadel.getIngridient().observe(viewLifecycleOwner) {
                                for (ingrident in it.withIndex())
                                    if (ingrident.index !in view.chipGroup.checkedChipIds)
                                        it[ingrident.index].delete = true
                                Log.d("MyERROR", "${pizza.about}")
                                dialog.dismiss()
                            }
                        }
                        .setNeutralButton("CLEAR") { dialog, which ->

                            dialog.dismiss()
                        }
                        .setView(view.root)
                        .show()
                }
                binding.nameShowder.setOnClickListener {
                    val view = setupChip(pizza)
                    MaterialAlertDialogBuilder(requireContext())
                        .setTitle("Убрать ингридиенты")

                        .setPositiveButton("ГОТОВО") { dialog, which: Int ->
                            dialog.dismiss()

                        }
                        .setNegativeButton("Сбросить") { dialog, which: Int ->
                            dialog.cancel()
                        }
                        .setView(view.root)
                        .show()
                }
                setupChipFurst(pizza)
                getRecycler()
                onClickSmail()
                onClickBig()
                onClickNormal()
                onClickType()
            }
            else -> {
                binding.apply {
                    recSous.visibility = View.INVISIBLE
                    linearLayout.visibility = View.INVISIBLE
                    removeIngrelienites.visibility = View.INVISIBLE
                    if (pizza.category == Constants.DESERTI)
                        linearLayout2.visibility = View.INVISIBLE
                }
            }
        }
        Glide
            .with(this)
            .load(pizza.image)
            .into(binding.imageShowOder)
        binding.nameShowder.text = pizza.name
        binding.description.text = pizza.name






     }






        fun getRecycler() {
            recycler = binding.recSous
            adapter = ListSousAdapter()
            recycler.adapter = adapter
            recycler.layoutManager = StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)
            adapter.sizeType = Constants.SREDNAYA
            adapter.submitList(dodoViewMadel.getVkus().value)
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }







    fun onClickSmail() {
        binding.small.setOnClickListener {
            binding.small.setBackgroundResource(R.drawable.backround_select)
            binding.big.setBackgroundResource(R.drawable.back_selcted)
            binding.normal.setBackgroundResource(R.drawable.back_selcted)
            binding.classic.setBackgroundResource(R.drawable.backround_select)
            binding.tonciy.setBackgroundResource(R.drawable.back_selcted)
            binding.imageShowOder.setImageResource(R.drawable.back_selcted)
            binding.tonciy.isGone = true
            binding.classic.width = ViewGroup.LayoutParams.MATCH_PARENT
            adapter.sizeType = Constants.MALENKAYA
            dodoViewMadel.getVkus().observe(viewLifecycleOwner){
                adapter.submitList(it)
            }
            seleltList()

        }
    }

    fun onClickBig() {
        binding.big.setOnClickListener {
            binding.small.setBackgroundResource(R.drawable.back_selcted)
            binding.big.setBackgroundResource(R.drawable.backround_select)
            binding.normal.setBackgroundResource(R.drawable.back_selcted)
            binding.tonciy.setBackgroundResource(R.drawable.back_selcted)
           // binding.imageShowOder.setImageResource(R.drawable.ingridient_1)

            adapter.sizeType = Constants.BOLSHAYA
            dodoViewMadel.getVkus().observe(viewLifecycleOwner){
                adapter.submitList(it)
            }

            binding.tonciy.isGone = false

        }
    }

    fun onClickNormal() {
        binding.normal.setOnClickListener {
            binding.small.setBackgroundResource(R.drawable.back_selcted)
            binding.big.setBackgroundResource(R.drawable.back_selcted)
            binding.normal.setBackgroundResource(R.drawable.backround_select)
            binding.tonciy.setBackgroundResource(R.drawable.back_selcted)
           // binding.imageShowOder.setImageResource(R.drawable.ingridient_12)

            adapter.sizeType = Constants.SREDNAYA
            dodoViewMadel.getVkus().observe(viewLifecycleOwner){
                adapter.submitList(it)
            }

            binding.tonciy.isGone = false

        }
    }

    fun onClickType() {
        binding.tonciy.setOnClickListener {
            binding.tonciy.setBackgroundResource(R.drawable.backround_select)
            binding.classic.setBackgroundResource(R.drawable.back_selcted)
           dodoViewMadel.getVkus().observe(viewLifecycleOwner) {


                adapter.submitList(it)
            }
        }

        fun onClickInfo() {
            binding.info.setOnClickListener {
            }
        }

        fun getSelectItem() {
            adapter.onClick = {
                val newList = mutableListOf<Vkus>()
                val periodicList = adapter.currentList

                for (index in periodicList.indices) {
                    if (index == it) {
                        val listes = periodicList[it].copy(select = true)
                        newList.add(listes)
                    } else {
                        newList.add(periodicList[index])
                    }
                    adapter.submitList(newList)

                }
            }
        }
    }

    private fun setupChip(pizza: Pizza): DeleteIngridientItemBinding {

      dodoViewMadel.getIngridient().observe(viewLifecycleOwner){ingridients->



        var view = DeleteIngridientItemBinding.inflate(layoutInflater)
        for (item in ingridients.withIndex()) {
            val chip = createChp(item.value.name)
            chip.id = item.index
            chip.setOnClickListener() {

            }
            if (view.chipGroup.contains(chip))
                view.chipGroup.removeAllViews()
            view.chipGroup.addView(chip)
            chip.isChecked = !item.value.delete
            ingridients.map {
                if (!it.delete) {
                    chip.isGone
                }
            }

            Log.d("MyERROR", "${chip.isChecked}")
        }

        view.chipGroup.setOnCheckedStateChangeListener { _, checkedIds ->
            val size = binding.descriptionShowder.size
            binding.descriptionShowder.removeAllViews()
            for (i in 0 until size) {
                val chip = createChiptext(ingridients[i].name)
                chip.id = i

                if (i !in checkedIds) {
                    val spannable = SpannableString(chip.text)
                    spannable.setSpan(
                        StrikethroughSpan(),
                        0,
                        chip.text.length,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                    chip.text = spannable
                }

                binding.descriptionShowder.addView(chip)
            }

        }
           view =view
    }
        return view
    }

    private fun setupChipFurst(pizza: Pizza) {
        val it= mutableListOf<String>()
        pizza.category.split(",").forEach {
            mutableListOf(it)
        }

        for ((count, item) in it.withIndex()) {
            val chip = createChiptext(item)
            chip.id = count
            binding.descriptionShowder.addView(chip)
        }
    }

    private fun createChiptext(category: String): TextView {
        val textView = ChipTextItemBinding.inflate(layoutInflater).root
        textView.text = category
        return textView
    }

    private fun createChp(category: String): Chip {
        val chip = ChipItemBinding.inflate(layoutInflater).root
        chip.text = category
        return chip
    }

    fun seleltList() {

        var newList = mutableListOf<Vkus>()
        dodoViewMadel.getVkus().observe(viewLifecycleOwner) {


            for (item in it) {
                newList.add(item.copy(select = false))
            }

            adapter.submitList(newList)
        }
    }
    companion object {

        fun newInstance(param1: islom.din.dodo_ilmhona_proskills.db.data.Pizza) =
            ShowFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, param1)


                }

            }
    }
}







