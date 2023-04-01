package islom.din.dodo_ilmhona_proskills.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dbfordodo.databinding.FragmentProfilFragementBinding
import com.example.dbfordodo.dodoViewMadel.DodoViewMadel
import com.example.dbfordodo.dodoViewMadel.HomeViewModel
import com.example.dbfordodo.dodoViewMadel.repository.DodoMadelFactory
import com.example.dbfordodo.dodoViewMadel.repository.GetPizzaList
import com.example.dbfordodo.dodoViewMadel.repository.HomeViewMadelFactory
import com.example.dbfordodo.view.DataBaseApplication
import islom.din.dodo_ilmhona_proskills.view.profil.OrderListAdapter
import java.util.Calendar

class ProfilFragement : Fragment() {
    private lateinit var binding: FragmentProfilFragementBinding
    private lateinit var adapter: OrderListAdapter
    //View Model
    //View Model
    private val dodoViewModel: DodoViewMadel by viewModels() {
        DodoMadelFactory(
            (requireActivity().application as DataBaseApplication).database.pizzaDao(),
            (requireActivity().application as DataBaseApplication).database.orderDao()
        )
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentProfilFragementBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = OrderListAdapter()
        binding.recyclerItem.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerItem.adapter = adapter

        dodoViewModel.getHistory().observe(viewLifecycleOwner){
            it.forEach{
                dodoViewModel.getPizzaId(it.userId).observe(viewLifecycleOwner){
                    adapter.submitList(it)
                }
            }

        }

        binding.coint.setOnClickListener {
            val acion = ProfilFragementDirections.actionProfilFragementToDodoCoinFragment()
            findNavController().navigate(acion)
        }
        binding.settingIcon.setOnClickListener {
            val action = ProfilFragementDirections.actionProfilFragementToSettingFragment()
            findNavController().navigate(action)
        }
        binding.adressUser.setOnClickListener {
            val action = ProfilFragementDirections.actionProfilFragementToAdressFragment()
            findNavController().navigate(action)
        }
        binding.hustoriOrder.setOnClickListener {
            val action = ProfilFragementDirections.actionProfilFragementToHistoryOrdersFragment()
            findNavController().navigate(action)
        }

    }
}