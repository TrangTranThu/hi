package com.example.day5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.day5.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private val binding by lazy { FragmentSecondBinding.inflate(layoutInflater) }
    private val mainActivity by lazy { activity as MainActivity }
    var fullname: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnReceive.setOnClickListener {
            binding.edFirstFragment.setText(mainActivity.fullName)
        }
    }
}