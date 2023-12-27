package com.gdsc.doguslive

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SearchUserAdapter(val context: Context) :
    RecyclerView.Adapter<SearchUserAdapter.ViewHolder>() {
    private var dataList: ArrayList<String> = arrayListOf()
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userNameText: TextView = itemView.findViewById(R.id.userNameText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_search_user, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.userNameText.text = dataList.get(position)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun updateList(newData: ArrayList<String>) {
        dataList.clear()
        dataList.addAll(newData)
        notifyDataSetChanged()
    }
}
