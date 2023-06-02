package com.example.pptapp.ui_for_offline_usage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pptapp.PPGame
import com.example.pptapp.R
import com.example.pptapp.databinding.OfflineAddTeamsBinding
import com.example.pptapp.databinding.OfflineFinalresultsPageBinding

class FinalResultsFragment : Fragment() {
    private lateinit var recv: RecyclerView
    private lateinit var myListAdapter: ResultsListAdapter
    private var _binding : OfflineFinalresultsPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = OfflineFinalresultsPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recv = binding.resultRecyclerView
        myListAdapter = ResultsListAdapter(requireContext(), PPGame.getPositionsList() )
        recv.layoutManager = LinearLayoutManager(requireContext())
        recv.adapter = myListAdapter
        myListAdapter.notifyDataSetChanged()
        binding.buttonBack.setOnClickListener {
            findNavController().navigate(R.id.action_finalResultsFragment_to_introPageActivity)
            PPGame.resetAllStats()


        }

    }
}