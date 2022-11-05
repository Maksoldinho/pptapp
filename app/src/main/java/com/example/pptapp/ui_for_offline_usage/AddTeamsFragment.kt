package com.example.pptapp.ui_for_offline_usage

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pptapp.MainPageActivity
import com.example.pptapp.PPGame
import com.example.pptapp.databinding.OfflineAddTeamsBinding

class AddTeamsFragment : Fragment() {
    private lateinit var recv: RecyclerView
    private lateinit var teamList: ArrayList<String>
    private lateinit var myListAdapter: MyListAdapter
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recv = binding.recyclerView3
        teamList = ArrayList()
        myListAdapter = MyListAdapter(requireContext(), teamList )
        recv.layoutManager = LinearLayoutManager(requireContext())
        recv.adapter = myListAdapter

            binding.btnAddPlayers.setOnClickListener {
                if(teamList.size < PPGame.getNumberOfTeams()) {
                    teamList.add(binding.editTextTeamName.text.toString())
                    myListAdapter.notifyDataSetChanged()
                    binding.editTextTeamName.text.clear()
                }else{
                    Toast.makeText(requireContext(),"Can't add more teams", Toast.LENGTH_SHORT).show()
                }
            }

        binding.btnBeginTournament.setOnClickListener {
            if (teamList.size == PPGame.getNumberOfTeams()){
                PPGame.setAllTeams(teamList)
            }
            else{
                Toast.makeText(requireContext(),"Please add more teams", Toast.LENGTH_SHORT).show()
            }
        }

    }
}