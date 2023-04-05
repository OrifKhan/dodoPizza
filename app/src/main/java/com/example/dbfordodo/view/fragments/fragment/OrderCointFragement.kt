package islom.din.dodo_ilmhona_proskills.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dbfordodo.databinding.FragmentOrderCointFragementBinding
import com.example.dbfordodo.view.adapter.ListAdapters.CoinOderAdapter

class OrderCointFragement : Fragment() {
    private lateinit var binding: FragmentOrderCointFragementBinding
    private lateinit var adapter: CoinOderAdapter
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentOrderCointFragementBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = CoinOderAdapter()
        binding.coinRecycler.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.coinRecycler.adapter = adapter

      //  adapter.submitList(GetPizzaList().getList())

    }

}