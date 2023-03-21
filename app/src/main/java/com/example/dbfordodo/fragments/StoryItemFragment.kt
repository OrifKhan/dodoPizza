package islom.din.dodo_ilmhona_proskills.shodmon.bekhruz

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.dbfordodo.R
import com.example.dbfordodo.databinding.FragmentStoryItemBinding
import com.example.dbfordodo.dodoViewMadel.DodoViewMadel
import com.example.dbfordodo.dodoViewMadel.repository.DodoMadelFactory
import com.example.dbfordodo.view.DataBaseApplication
import com.genius.multiprogressbar.MultiProgressBar


class StoryItemFragment : Fragment(), MultiProgressBar.ProgressStepChangeListener,
    MultiProgressBar.ProgressFinishListener {

    private lateinit var binding: FragmentStoryItemBinding
    private val dodoViewModel: DodoViewMadel by activityViewModels(){
        DodoMadelFactory(Application(),(requireActivity().application as DataBaseApplication).database.pizzaDao())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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

        binding.storyProgressBar.setSingleDisplayTime(5f)
        binding.storyProgressBar.setProgressStepsCount(16)
        binding.storyProgressBar.setListener(this)
        binding.storyProgressBar.setFinishListener(this)


        binding.leftView.setOnClickListener {
            binding.storyProgressBar.previous()
        }
        binding.rightView.setOnClickListener {
            binding.storyProgressBar.next()
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

        val image = dodoViewModel.getStores(newStep).observe(viewLifecycleOwner){
            it.forEach(){
                Glide.with(binding.root)
                    .load(it.image)
                    .into(binding.image)
            }

        }


    }

    override fun onProgressFinished() {
        Log.d("TESTING", "onProgressFinished: ")

        val pager = requireActivity().findViewById<ViewPager2>(R.id.view_pager)
        pager.currentItem += 1


    }

}
