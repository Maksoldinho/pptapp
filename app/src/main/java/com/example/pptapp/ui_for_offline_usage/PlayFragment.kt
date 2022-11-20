package com.example.pptapp.ui_for_offline_usage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pptapp.PPGame
import com.example.pptapp.databinding.OfflineAddTeamsBinding
import com.example.pptapp.databinding.OfflinePlayBinding

class PlayFragment: Fragment() {
    private var _binding:OfflinePlayBinding? = null
    private val binding get() = _binding!!

    private lateinit var recv: RecyclerView
    private lateinit var matchesList: MutableMap<String,String>
    private lateinit var myListAdapter: MatchesListAdapter

    private val teams = PPGame.getTeams()
    private val amountOfTeams = teams.size

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = OfflinePlayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recv = binding.playRecyclerView
        matchesList = mutableMapOf()
        myListAdapter = MatchesListAdapter(requireContext(), matchesList )
        recv.layoutManager = LinearLayoutManager(requireContext())
        recv.adapter = myListAdapter

        for(i in 1..amountOfTeams/2){
            if(amountOfTeams == 2){
                matchesList.put(teams[i-1], teams[i])
            }
            else if (amountOfTeams == 4){
                matchesList.put(teams[i-1], teams[i+1])
            }
            else if(amountOfTeams == 8){
                matchesList.put(teams[i-1], teams[i+3])
            }
        }
        println("Map: $matchesList")
        myListAdapter.notifyDataSetChanged()
    }
}