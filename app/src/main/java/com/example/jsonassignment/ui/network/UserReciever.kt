package com.example.jsonassignment.ui.network

import com.example.jsonassignment.network.NetworkInterface
import com.example.jsonassignment.ui.models.Users
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserReciever {
    private val networkInterface:NetworkInterface

    companion object{
        var BASE_URL = "https://my-json-server.typicode.com/"
    }

    init {

        val retrofit = Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        networkInterface = retrofit.create(NetworkInterface::class.java)
    }

    suspend fun getUsers(): List<Users> {
        return networkInterface.getUsers()
    }
}