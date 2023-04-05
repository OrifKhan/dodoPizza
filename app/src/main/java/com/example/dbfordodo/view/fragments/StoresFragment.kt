package com.example.dbfordodo.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.dbfordodo.databinding.FragmentStoresBinding
import com.example.dbfordodo.dodoViewMadel.madelFactory.DodoMadelFactory
import com.example.dbfordodo.dodoViewMadel.viewModel.DodoViewMadel
import com.example.dbfordodo.view.HelperClass.DataBaseApplication
import com.example.dbfordodo.view.adapter.ViewPager.VpAdapter

class StoresFragment : Fragment() {
    private var _binding: FragmentStoresBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: VpAdapter

    private val args: StoresFragmentArgs by navArgs()

    private val dodoViewMadel: DodoViewMadel by activityViewModels {
        DodoMadelFactory(
            (requireActivity().application as DataBaseApplication).database.pizzaDao(),
            (requireActivity().application as DataBaseApplication).database.orderDao()
        )
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentStoresBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dodoViewMadel.getMaineStores(true).observe(viewLifecycleOwner) {
            binding.viewPager.currentItem = args.pos
            adapter = VpAdapter(it, requireActivity())
            Log.d("stores", "${args.pos}")
            binding.viewPager.adapter = adapter
            binding.viewPager.currentItem = args.pos
        }
    }
}