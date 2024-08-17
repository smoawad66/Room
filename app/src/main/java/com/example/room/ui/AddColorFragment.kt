package com.example.room.ui

import android.graphics.Color.parseColor
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.room.R
import com.google.android.material.textfield.TextInputEditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.room.App
import com.example.room.databinding.FragmentAddColorBinding
import com.example.room.models.Color
import com.example.room.ui.viewModel.ColorViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class AddColorFragment : Fragment() {

    private lateinit var binding: FragmentAddColorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddColorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val colorViewModel = App.getColorViewModel(this)

        binding.apply {
            tvColor.setOnClickListener {
                val hex = edtHex.text.toString()
                val parsedColor = getParsedColor(hex)
                if (parsedColor is Int) {
                    tvColor.setBackgroundColor(parsedColor)
                }
            }
        }

        binding.apply {
            btnAdd.setOnClickListener {
                val name = edtName.text.toString()
                val hex = edtHex.text.toString()

                if (getParsedColor(hex) == false) {
                    return@setOnClickListener
                }

                lifecycleScope.launch {
                    withContext(Dispatchers.IO) {
                        colorViewModel.insertColor(Color(name = name, hex = hex))
                    }
                    Toast.makeText(requireContext(), "Color added successfully!", Toast.LENGTH_SHORT).show()
                    requireActivity().supportFragmentManager.popBackStack()
                }
            }

        }
    }

    private fun getParsedColor(value: String): Any {
        val parsedColor: Int
        try {
            parsedColor = parseColor('#'.plus(value))
        } catch (_: IllegalArgumentException) {
            Toast.makeText(this.requireContext(), "Invalid Color!", Toast.LENGTH_SHORT).show()
            return false
        }
        return parsedColor
    }

}