package com.example.day5_task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.day5_task.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }
    private val postList: MutableList<Account> = mutableListOf(
        Account("Trang"),
        Account("Thùy"),
        Account("Minh"),
        Account("Anh")
    )
    private val storyList: MutableList<Account> = mutableListOf(
        Account("Daisies"),
        Account("Miksa"),
        Account("ren"),
        Account("Daisies"),
        Account("Miksa"),
        Account("ren")
    )

    private val userAdapter = AccountAdapter(postList)
    private val storyAdapter = StoryAdapter(storyList)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.recViewStory.adapter = storyAdapter
        binding.recViewStory.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        binding.recyclerViewPost.adapter = userAdapter
        binding.recyclerViewPost.layoutManager = LinearLayoutManager(requireContext())

    }
}