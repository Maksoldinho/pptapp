package com.example.pptapp.ui_for_offline_usage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.pptapp.R

class MyListAdapter(private val context: Context, private val mylist: ArrayList<String>) : RecyclerView.Adapter<MyListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyListAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.list_item,parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val newList = mylist[position]
        holder.name.text = "${position+1}. $newList"
        holder.initialize(newList)
    }

    override fun getItemCount(): Int {
        return mylist.size
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val name = itemView.findViewById<TextView>(R.id.mTitle)
        val button_delete = itemView.findViewById<Button>(R.id.button_deletePlayer)
//        fun bind(myItem: String){
//            itemView.setOnClickListener{
//                Toast.makeText(context, myItem, Toast.LENGTH_LONG).show()
//            }
//        }

        fun initialize(teamName:String){
            button_delete.setOnClickListener {
                println(mylist)
                mylist.remove(teamName)
                notifyDataSetChanged()
                println("I am pressed")
                println(mylist)
            }
        }
    }
}
