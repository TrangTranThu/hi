package com.example.day5_task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.day5_task.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private val binding by lazy { FragmentProfileBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//            binding.btnHello.setOnClickListener{
//                Toast.makeText(requireContext(), "helo", Toast.LENGTH_LONG).show()
    }
}
