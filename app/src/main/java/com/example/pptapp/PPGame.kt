package com.example.pptapp

import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

object PPGame {
    private var numOfTeams: Int = 0
    private var teams = ArrayList<String>()
    private lateinit var matches: MutableMap<String, String>
    private var winners = ArrayList<String>()
    private var losers = ArrayList<String>()
    private var positionsList = ArrayList<String>()



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
    fun setMatches(_matches: MutableMap<String, String>){
        matches = _matches
        println("Printing matches from PPGame.kt $matches")
    }
    fun getMatches(): MutableMap<String, String>{
        return matches
    }
    fun addWinner(team_winner: String){
        winners.add(team_winner)
    }

    fun addLoser(team_winner: String){
        losers.add(team_winner)
    }
    fun getLoser():String{
        return losers[0]
    }
    fun getWinners() : ArrayList<String>{
        return winners
    }
    fun thirdPlaceGame(team_one: String, team_two: String): Boolean{
        if(losers.size!= 0) {
            return PPGame.getLoser() == team_one || PPGame.getLoser() == team_two
        }else return false
    }
    fun moveToNextStage(){
        teams = winners
        matches.clear()
        for(i in 1..teams.size/2){
            if(teams.size == 2){
                matches.put(teams[i-1], teams[i])
            }
            else if (teams.size == 4){
                matches.put(teams[i-1], teams[i+1])
            }
            else if(teams.size == 8){
                matches.put(teams[i-1], teams[i+3])
            }
        }
        if(teams.size == 2){
            matches.put(losers[0], losers[1])
        }
        println("Printing teams from PPGame.kt $teams")
        println("Printing winners from PPGame.kt $winners")
        println("Printing matches from PPGame.kt $matches")
        winners = ArrayList()
        println("Printing teams from PPGame.kt $teams")
        println("Printing winners from PPGame.kt $winners")
    }
    fun setResultForFinals(team_firstPlace: String, team_secondPlace:String){
        positionsList.add(team_firstPlace)
        positionsList.add(team_secondPlace)
    }
    fun setResultForThirdPlace(team_thirdPlace: String, teamFourthPlace:String){
        positionsList.add(team_thirdPlace)
        positionsList.add(teamFourthPlace)
    }
    fun getPositionsList(): ArrayList<String>{
        return positionsList
    }
    fun isFinals(): Boolean{
        return teams.size == 2 && matches.size == 2 || teams.size == 2 && matches.size == 1
    }
    fun resetAllStats(){
        winners.clear()
        losers.clear()
        teams.clear()
        matches.clear()
        numOfTeams = 0
        positionsList.clear()
    }


}