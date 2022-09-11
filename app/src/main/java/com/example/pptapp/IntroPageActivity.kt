package com.example.pptapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pptapp.databinding.EntryPageBinding
import com.example.pptapp.databinding.IntroPageBinding

class IntroPageActivity:Fragment() {
    var _binding : IntroPageBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = IntroPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.goOfflineBtn.setOnClickListener {

        }
        binding.goOnlineBtn.setOnClickListener {
            findNavController().navigate(R.id.action_introPageActivity_to_entryPageActivity)
        }
    }
}