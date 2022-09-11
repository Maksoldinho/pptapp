package com.example.pptapp.ui_for_online_usage.match_history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pptapp.databinding.FragmentJointournamentBinding
import com.example.pptapp.databinding.FragmentMatchhistoryBinding

class MatchHistoryFragment : Fragment() {
    private var _binding: FragmentMatchhistoryBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMatchhistoryBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println()
    }
}