//package islom.din.dodo_ilmhona_proskills.shodmon.bekhruz
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import com.example.dbfordodo.databinding.FragmentStoryBinding
//import com.example.dbfordodo.view.ViewPager.VpAdapter
//
//
//class StoryFragment : Fragment() {
//    private lateinit var binding: FragmentStoryBinding
//    private lateinit var vpAdapter : VpAdapter
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        binding = FragmentStoryBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//
//        //TODO:
//        // 1) Create adapter instance and set it to viewPages's adapter
//        // 2) Start progress view line
//
//        binding.viewPager.adapter = VpAdapter(listOf(), requireActivity())
//
//
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        //Warning!!! DO NOT DO THIS
//        //binding.root
//    }
//
//}
//
//
