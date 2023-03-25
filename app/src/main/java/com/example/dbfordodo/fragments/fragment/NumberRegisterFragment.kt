package islom.din.dodo_ilmhona_proskills.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.dbfordodo.databinding.FragmentNumberRegisterBinding

class NumberRegisterFragment() :Fragment() {
     private lateinit var binding: FragmentNumberRegisterBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNumberRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextContinue.setOnClickListener {
            val action =
                NumberRegisterFragmentDirections.actionNumberRegisterFragmentToPasswordFragment()
            findNavController().navigate(action)
        }
    }
}