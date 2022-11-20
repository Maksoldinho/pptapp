package com.example.pptapp

import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

object PPGame {
    private var numOfTeams: Int = 0
    private var teams = ArrayList<String>()

    fun setNumberOfTeams(number: Int){
        println("number of teams: $number")
        numOfTeams = number
    }
    fun getNumberOfTeams(): Int {
        return numOfTeams
    }
    fun setAllTeams(teamNames: ArrayList<String>){
        teams = teamNames
        for(team in teams){
            println(team)
        }
    }
    fun getTeams() : ArrayList<String>{
        return teams
    }



}