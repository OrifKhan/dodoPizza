package islom.din.dodo_ilmhona_proskills.shodmon.bekhruz

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.dbfordodo.R
import com.example.dbfordodo.databinding.FragmentStoryItemBinding
import com.example.dbfordodo.dodoViewMadel.DodoViewMadel
import com.example.dbfordodo.dodoViewMadel.repository.DodoMadelFactory
import com.example.dbfordodo.view.DataBaseApplication
import com.genius.multiprogressbar.MultiProgressBar
import islom.din.dodo_ilmhona_proskills.shodmon.khushbakht.StoryData

private const val ARG_STORES = "stores"
private const val ARG_POS = "pos"
class StoryItemFragment : Fragment(), MultiProgressBar.ProgressStepChangeListener,
    MultiProgressBar.ProgressFinishListener {
   private var _stores:Int?=null
   private val stores get() =_stores!!

    private var _pos:Int?=null
    private val pos get()=_pos!!

    private lateinit var binding: FragmentStoryItemBinding
    private val dodoViewModel: DodoViewMadel by activityViewModels {
        DodoMadelFactory((requireActivity().application as DataBaseApplication).database.pizzaDao(),
            (requireActivity().application as DataBaseApplication).database.orderDao())
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            _stores = it.getInt(ARG_STORES)
            _pos=it.getInt(ARG_POS)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentStoryItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dodoViewModel.getStores(pos).observe(viewLifecycleOwner) {


            binding.storyProgressBar.setSingleDisplayTime(5f)
            binding.storyProgressBar.setProgressStepsCount(it.size)
            binding.storyProgressBar.setListener(this)
            binding.storyProgressBar.setFinishListener(this)
            it.forEach(){
                binding.image.setImageResource(it.image)
            }

            binding.leftView.setOnClickListener {
                binding.storyProgressBar.previous()
            }
            binding.rightView.setOnClickListener {
                binding.storyProgressBar.next()
            }


        }
    }

    override fun onStart() {
        super.onStart()
        binding.storyProgressBar.start()

    }

    override fun onResume() {
        binding.storyProgressBar.start()
        super.onResume()
    }


    override fun onStop() {
        binding.storyProgressBar.pause()
        super.onStop()
    }


    override fun onProgressStepChange(newStep: Int) {
        Log.d("TESTING", "New step --> $newStep")

    }





    override fun onProgressFinished() {
        Log.d("TESTING", "onProgressFinished: ")

        val pager = requireActivity().findViewById<ViewPager2>(R.id.viewPager)
        pager.currentItem += 1


    }
    companion object{
        fun newInstance(stores:StoryData,pos: Int) =
            StoryItemFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_STORES,stores.image)
                    putInt(ARG_POS,pos)



                }

            }


        }
    }

