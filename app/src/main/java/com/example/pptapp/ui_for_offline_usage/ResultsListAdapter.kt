package com.example.pptapp.ui_for_offline_usage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pptapp.R

class ResultsListAdapter(private val context: Context, private val mylist: ArrayList<String>) : RecyclerView.Adapter<ResultsListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultsListAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.result_item,parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val newList = mylist[position]
        holder.name.text = "${position+1}. $newList"
    }

    override fun getItemCount(): Int {
        return mylist.size
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val name = itemView.findViewById<TextView>(R.id.text_view_resultPlace)
//        fun bind(myItem: String){
//            itemView.setOnClickListener{
//                Toast.makeText(context, myItem, Toast.LENGTH_LONG).show()
//            }
//        }
    }
}