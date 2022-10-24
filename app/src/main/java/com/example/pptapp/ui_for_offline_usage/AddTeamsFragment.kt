package com.example.pptapp.ui_for_offline_usage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pptapp.databinding.OfflineAddTeamsBinding

class AddTeamsFragment : Fragment() {
    private var _binding : OfflineAddTeamsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = OfflineAddTeamsBinding.inflate(inflater, container, false)
        return binding.root
    }
}