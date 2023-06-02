package com.example.pptapp.ui_for_offline_usage

import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.ShapeDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupMenu
import android.widget.PopupWindow
import android.widget.TextView
import androidx.fragment.app.findFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.pptapp.PPGame
import com.example.pptapp.R

class MatchesListAdapter(private val context: Context, private val mylist: Map<String,String>) : RecyclerView.Adapter<MatchesListAdapter.ViewHolder>() {
    lateinit var view: View
    var x = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchesListAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.play_item,parent, false)
        view = inflater.inflate(R.layout.popup_window, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val teamones = mylist.keys.toList()
        val teamone = teamones[x]
        val teamtwo = mylist[teamone]
        holder.play_off_stage.text = if (PPGame.getTeams().size == 2) "Game for medals!!" else "1/${(PPGame.getTeams().size / 2)}"
        holder.team_name_one.text = teamone
        holder.team_name_two.text = teamtwo
        holder.initialize(teamone, teamtwo)
        x += 1
    }

    override fun getItemCount(): Int {
        return mylist.size
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val play_off_stage = itemView.findViewById<TextView>(R.id.playoff_stage_tv)
        val team_name_one = itemView.findViewById<TextView>(R.id.team_name_1)
        val team_name_two = itemView.findViewById<TextView>(R.id.team_name_2)
        val button_play = itemView.findViewById<Button>(R.id.match_play_btn)


        fun initialize(team_one: String, team_two: String?) {

            var winOpened = false
            println(button_play)
            button_play.setOnClickListener {
                val window = PopupWindow(itemView.context)
                val team_one_btn = view.findViewById<Button>(R.id.btn_team_one)
                val team_two_btn = view.findViewById<Button>(R.id.btn_team_two)
                val semifinals = PPGame.getTeams().size== 4

//              Даём командам имена
                team_one_btn.text = team_one
                team_two_btn.text = team_two

                team_one_btn.setOnClickListener {
                    winOpened = false
                    PPGame.addWinner(team_one)
                    if(semifinals){
                        println("We are in semis!")
                        PPGame.addLoser(team_two!!)
                    }
                    if (PPGame.isFinals()){
                        println("We are in finals!!")
                        if(PPGame.thirdPlaceGame(team_one, team_two!!)){
                            PPGame.setResultForThirdPlace(team_one, team_two!!)
                        }else{
                            PPGame.setResultForFinals(team_one, team_two!!)
                        }
                    }
                    window.dismiss()
                }
                team_two_btn.setOnClickListener {
                    winOpened = false
                    PPGame.addWinner(team_two!!)
                    if(semifinals){
                        println("We are in semis!")
                        PPGame.addLoser(team_one)
                    }
                    if (PPGame.isFinals()){
                        println("We are in finals!!")
                        if(PPGame.thirdPlaceGame(team_one, team_two!!)){
                            PPGame.setResultForThirdPlace(team_two, team_one)
                        }else{
                            PPGame.setResultForFinals(team_two, team_one)
                        }
                    }
                    window.dismiss()
                }
                window.contentView = view
                window.setBackgroundDrawable(Drawable.createFromPath("C:\\Users\\Maksim\\AndroidStudioProjects\\pptapp\\app\\src\\main\\res\\drawable\\edit_text_rounded_background.xml"))
                window.showAtLocation(itemView, Gravity.CENTER,0,0)
                if (!winOpened) {
                    window.showAsDropDown(button_play)
                    winOpened = true
                }
                if(PPGame.getPositionsList().size!=0) {
                    println(PPGame.getPositionsList())
                }
                println("Winners: ${PPGame.getWinners().size}")
                println("Teams/2: ${PPGame.getTeams().size/2}")
            }

        }
    }
}

