package com.example.room.ui

import ColorViewModelFactory
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.room.App
import com.example.room.R
import com.example.room.local.LocalDataSource
import com.example.room.repo.Repo
import com.example.room.ui.viewModel.ColorViewModel
//import com.example.room.ui.viewModel.ColorViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ColorsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var btn_add: FloatingActionButton
    private lateinit var viewModel: ColorViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        return inflater.inflate(R.layout.fragment_colors, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_add = view.findViewById(R.id.btn_add)
        recyclerView = view.findViewById(R.id.rv)

        viewModel = App.getColorViewModel(this)

        val adapter = ColorsAdapter(emptyList())

        viewModel.colors.observe(viewLifecycleOwner) {
            adapter.setData(it)
            recyclerView.adapter = adapter
        }

        adapter.setOnItemClickListener { position ->
            val navController = view.findNavController()
            val color = adapter.getData()[position]
            val action = ColorsFragmentDirections.actionColorsFragmentToColorFragment(color)
            navController.navigate(action)
        }

        btn_add.setOnClickListener {
            val navController = view.findNavController()
            val action = ColorsFragmentDirections.actionColorsFragmentToAddColorFragment()
            navController.navigate(action)
        }

    }
}