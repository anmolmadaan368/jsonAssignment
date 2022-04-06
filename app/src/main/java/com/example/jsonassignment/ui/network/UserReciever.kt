package com.example.jsonassignment.ui.network

import com.example.jsonassignment.network.NetworkInterface
import com.example.jsonassignment.ui.models.Users
import com.example.jsonassignment.ui.models.UsersItem
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserReciever {


    companion object{





        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://my-json-server.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val networkInterface:NetworkInterface by lazy {
            retrofit.create(NetworkInterface::class.java)
        }
    }


    init {

    }

    suspend fun getUsers(): List<UsersItem> {
        return networkInterface.getUsers()
    }
}