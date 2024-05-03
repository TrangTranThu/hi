package com.example.day8_task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.day8_task.databinding.FragmentAllNoteBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllNoteFragment : Fragment() {

    private val binding by lazy { FragmentAllNoteBinding.inflate(layoutInflater) }
    private lateinit var adapter: NoteListAdapter
    private lateinit var noteDB: NoteRoomDatabase
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        noteDB = NoteRoomDatabase.getDatabase(requireContext())
        adapter = NoteListAdapter(noteDB)

        binding.rvAllNotes.adapter = adapter
        binding.rvAllNotes.layoutManager = LinearLayoutManager(requireContext())

        refreshNoteList()

    }

    fun refreshNoteList() {
        CoroutineScope(Dispatchers.IO).launch {
            adapter.updateNotes(noteDB.noteDao().getAllNotes())
        }
    }
}