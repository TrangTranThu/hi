package com.example.mvvc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mvvc.databinding.FragmentListBinding


class ListFragment : Fragment() {
    private val binding by lazy { FragmentListBinding.inflate(layoutInflater) }
    private val viewModel by lazy { ViewModelProvider(this)[ListViewModel::class.java] }

    var result = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAddNewNote.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

//        binding.btnPlus.setOnClickListener {
//            result++
//            binding.edHiHi.setText("$result")
//        }

        viewModel.result.observe(viewLifecycleOwner){value->
            binding.edHiHi.setText("$value")
        }
        binding.btnPlus.setOnClickListener {
            viewModel.Plus()
        }

    }
}