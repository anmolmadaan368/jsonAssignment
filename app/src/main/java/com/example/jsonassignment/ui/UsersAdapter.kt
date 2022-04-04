package com.example.jsonassignment.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonassignment.R
import com.example.jsonassignment.ui.models.Users
import com.example.jsonassignment.ui.models.UsersItem
import kotlinx.android.synthetic.main.user_item.view.*

class UsersAdapter(private val context:Context,private var usersResponse: ArrayList<UsersItem>) :RecyclerView.Adapter<UsersAdapter.ViewHolder>(){
    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(users: UsersItem){
            itemView.txtName.text = users.name
          //  itemView.txtSubject.text = users.subjects.toString()

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.user_item,parent,false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(users = usersResponse[position])
    }

    override fun getItemCount(): Int {
      return usersResponse.size
    }

    fun setUserData(postList: ArrayList<UsersItem>) {
        this.usersResponse = postList
        notifyDataSetChanged()
    }
}