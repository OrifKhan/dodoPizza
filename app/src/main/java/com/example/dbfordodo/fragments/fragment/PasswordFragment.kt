package islom.din.dodo_ilmhona_proskills.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.dbfordodo.databinding.FragmentPassvordBinding
import com.example.dbfordodo.fragments.HomeFragment

class PasswordFragment : Fragment() {
    private lateinit var binding: FragmentPassvordBinding

    private val args :PasswordFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentPassvordBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPreference = requireActivity().getSharedPreferences("number_user", Context.MODE_PRIVATE)
       val edit=sharedPreference.edit()
        edit.apply(){
            putInt("number",args.number.toInt())
        }

        binding.getNewCod.setOnClickListener {

            val action = PasswordFragmentDirections.actionPasswordFragmentToProfilFragement()
            findNavController().navigate(action)
        }
    }
}