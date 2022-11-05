package com.example.pptapp

object PPGame {
    private var numOfTeams: Int = 0
    private var teams = List<String>(numOfTeams){""}

    fun setNumberOfTeams(number: Int){
        println("number of teams: $number")
        numOfTeams = number
    }
    fun getNumberOfTeams(): Int {
        return numOfTeams
    }
    fun setAllTeams(teamNames: List<String>){
        teams = teamNames
        for(team in teams){
            println(team)
        }
    }


}