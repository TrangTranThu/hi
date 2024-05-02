package com.example.day5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.day5.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private val binding by lazy { FragmentFirstBinding.inflate(layoutInflater) }
    private val mainActivity by lazy { activity as MainActivity }
    var fullname: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.btnHello.setOnClickListener{
//            Toast.makeText(requireContext(), "helo", Toast.LENGTH_LONG).show()
//        }
//        binding.btnHello.setOnClickListener{
//            fullname = binding.edFirstFragment.text.toString()
//        }

        binding.btnHello.setOnClickListener {
//            fullname = binding.edFirstFragment.text.toString()
//                binding.edFirstFragment.setText(mainActivity.fullName)
            mainActivity.fullName = binding.edFirstFragment.text.toString()
        }


    }
}
// acti<>fragmenr
//frag<>frag