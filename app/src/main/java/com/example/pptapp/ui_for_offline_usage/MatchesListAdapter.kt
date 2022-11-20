package com.example.pptapp.ui_for_offline_usage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pptapp.R

class MatchesListAdapter(private val context: Context, private val mylist: Map<String,String>) : RecyclerView.Adapter<MatchesListAdapter.ViewHolder>() {
    var x = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchesListAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.play_item,parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val teamones = mylist.keys.toList()
        val teamone = teamones[x]
        val teamtwo = mylist[teamone]
        holder.team_name_one.text = teamone
        holder.team_name_two.text = teamtwo
        x += 1
    }

    override fun getItemCount(): Int {
        return mylist.size
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val play_off_stage = itemView.findViewById<TextView>(R.id.playoff_stage_tv)
        val team_name_one = itemView.findViewById<TextView>(R.id.team_name_1)
        val team_name_two = itemView.findViewById<TextView>(R.id.team_name_2)
        val button_play = itemView.findViewById<Button>(R.id.btn_play)
    }
}