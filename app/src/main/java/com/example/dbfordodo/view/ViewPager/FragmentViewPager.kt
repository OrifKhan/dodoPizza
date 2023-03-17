package islom.din.dodo_ilmhona_proskills.view.ViewPager

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.example.dbfordodo.databinding.ViewpagerLayoutBinding
import com.example.dbfordodo.dodoViewMadel.DodoViewMadel
import com.example.dbfordodo.dodoViewMadel.repository.DodoMadelFactory
import com.example.dbfordodo.fragments.HomeFragment
import com.example.dbfordodo.view.DataBaseApplication
import kotlin.math.abs

class FragmentViewPager : Fragment() {
    private var _binding: ViewpagerLayoutBinding? = null
    private val binding get() = _binding!!

    //Room View Model
    private val dodoViewMadel: DodoViewMadel by activityViewModels {
        DodoMadelFactory(
            Application(),
            (requireActivity().application as DataBaseApplication).database.pizzaDao()
        )
    }

    private val args: FragmentViewPagerArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        _binding = ViewpagerLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dodoViewMadel.getAllSizeNormal(2).observe(viewLifecycleOwner) {


            val adapter = ViewPagerAdapter(this, it,args.pos)
            Log.d("tet", "$adapter.itemCount")
            binding.viewPagerLayout.adapter = adapter
            binding.viewPagerLayout.setPageTransformer(getTransformation())
          //  binding.viewPagerLayout.currentItem = args.pos
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        private fun getTransformation(): CompositePageTransformer {
            val transformer = CompositePageTransformer()
            transformer.addTransformer(MarginPageTransformer(30))
            transformer.addTransformer { page, position ->
                page.scaleY = 0.85f + (1 - abs(position)) * 0.15f
            }
            return transformer
        }
    }

}