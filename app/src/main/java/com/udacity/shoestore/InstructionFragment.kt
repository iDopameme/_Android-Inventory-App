package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentInstructionBinding
import timber.log.Timber

class InstructionFragment : Fragment() {
    private var _binding: FragmentInstructionBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInstructionBinding.inflate(inflater, container, false)

        binding.shoeListButton.setOnClickListener {
            Timber.e("Button clicked")
            findNavController().navigate(InstructionFragmentDirections.instructionToShoeList())
        }

        return binding.root
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_instruction, container, false)
    }
}