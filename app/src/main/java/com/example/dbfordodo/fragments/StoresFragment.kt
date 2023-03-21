package com.example.dbfordodo.fragments

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.dbfordodo.R
import com.example.dbfordodo.databinding.FragmentStoresBinding
import com.example.dbfordodo.dodoViewMadel.DodoViewMadel
import com.example.dbfordodo.dodoViewMadel.repository.DodoMadelFactory
import com.example.dbfordodo.view.DataBaseApplication
import com.example.dbfordodo.view.ViewPager.VpAdapter
import islom.din.dodo_ilmhona_proskills.shodmon.khushbakht.StoryData

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class StoresFragment : Fragment() {
    private var _binding: FragmentStoresBinding ?=null
     private val binding get() = _binding!!
    private lateinit var adapter: VpAdapter
    private val args: StoresFragmentArgs by navArgs()
     private val dodoViewModel: DodoViewMadel by activityViewModels(){
        DodoMadelFactory(Application(),(requireActivity().application as DataBaseApplication).database.pizzaDao())
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
        dodoViewModel.getMaineStores(true).observe(viewLifecycleOwner){
            adapter=VpAdapter(it,requireActivity(),args.pos)
        binding.viewPager.adapter=adapter
            binding.viewPager.currentItem=args.pos
    }
    }
}