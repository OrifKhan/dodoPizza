package islom.din.dodo_ilmhona_proskills.view.fragments.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.dbfordodo.databinding.FragmentMeetBinding
import islom.din.dodo_ilmhona_proskills.view.fragment.MeetFragmentDirections

class MeetFragment : Fragment() {
    private lateinit var binding: FragmentMeetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentMeetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setNumber.setOnClickListener {
            val action = MeetFragmentDirections.actionMeetFragment2ToNumberRegisterFragment()
            findNavController().navigate(action)
        }
    }

}