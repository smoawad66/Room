package com.example.room.ui

import ColorViewModelFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.example.room.R
import com.example.room.models.Color
import android.graphics.Color.parseColor
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.room.App
import com.example.room.databinding.FragmentColorBinding
import com.example.room.local.LocalDataSource
import com.example.room.repo.Repo
import com.example.room.ui.viewModel.ColorViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ColorFragment : Fragment() {

    private lateinit var binding: FragmentColorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentColorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: ColorFragmentArgs by navArgs()
        val colorViewModel = App.getColorViewModel(this)
        val color = args.color

        val hex = '#'.plus(color.hex)

        binding.apply {
            tvColor.setBackgroundColor(parseColor(hex))
            tvHex.text = hex
            tvName.text = color.name
        }

        binding.btnDelete.setOnClickListener {
            lifecycleScope.launch {
                withContext(Dispatchers.IO){
                    colorViewModel.deleteColor(color)
                }
                Toast.makeText(requireContext(), "Color deleted successfully!", Toast.LENGTH_SHORT).show()
                requireActivity().supportFragmentManager.popBackStack()
            }
        }

    }
}