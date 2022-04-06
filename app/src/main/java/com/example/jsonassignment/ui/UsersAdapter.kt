package com.example.jsonassignment.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jsonassignment.R
import com.example.jsonassignment.ui.models.Users
import com.example.jsonassignment.ui.models.UsersItem
import kotlinx.android.synthetic.main.user_item.view.*
import org.w3c.dom.Text

class UsersAdapter(private val context:Context,private var usersResponse: ArrayList<UsersItem>) :RecyclerView.Adapter<UsersAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.user_item,parent,false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(users = usersResponse[position])
        val user = usersResponse[position]

//        holder.id.text = post.id
        holder.title.text = user.name
        holder.subject.text=user.subjects.toString()

        Glide.with(holder.itemView.context)
            .load(user.profileImage)
            .into(holder.itemView.image)

    }

    override fun getItemCount(): Int {
      return usersResponse.size
    }

    fun setUserData(postList: ArrayList<UsersItem>) {
        this.usersResponse = postList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        //        fun bind(users: UsersItem){
//            itemView.txtName.text = users.name
        val title: TextView = itemView.findViewById(R.id.txtName)
        val subject:TextView = itemView.findViewById(R.id.txtSubject)
        val image:ImageView = itemView.findViewById(R.id.image)
        //  itemView.txtSubject.text = users.subjects.toString()


    }
}