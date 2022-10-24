package com.example.pptapp.ui_for_offline_usage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pptapp.R
import com.example.pptapp.databinding.FragmentCreatetournamentBinding
import com.example.pptapp.databinding.OfflineSelectPageBinding

class SelectPageFragment : Fragment() {
    private var _binding : OfflineSelectPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = OfflineSelectPageBinding.inflate(inflater, container, false)
        val spinner = binding.spinnerNumberOfTeams

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.number_of_teams,
            android.R.layout.simple_spinner_item
        ).also { adapter->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
            spinner.adapter = adapter
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_selectPageFragment_to_addTeamsFragment)
        }
    }
}