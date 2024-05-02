package com.example.day7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.day7.databinding.FragmentAllNoteBinding
import java.util.Date


class AllNoteFragment : Fragment() {

    private val binding by lazy { FragmentAllNoteBinding.inflate(layoutInflater) }
    private lateinit var noteList: MutableList<Note>
    private lateinit var adapterNote: AdapterNote

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding.recAllNote.adapter = AdapterNote(NoteSave.noteList)
        binding.recAllNote.layoutManager = LinearLayoutManager(requireContext())
    }
}