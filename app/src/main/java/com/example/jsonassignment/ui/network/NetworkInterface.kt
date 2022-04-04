package com.example.jsonassignment.network

import com.example.jsonassignment.ui.models.Users
import retrofit2.http.GET

interface NetworkInterface {

    @GET("easygautam/data/users")
    suspend fun getUsers():List<Users>
}