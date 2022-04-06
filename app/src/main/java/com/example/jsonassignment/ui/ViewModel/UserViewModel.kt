package com.example.jsonassignment.ui.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jsonassignment.ui.models.Users
import com.example.jsonassignment.ui.models.UsersItem
import com.example.jsonassignment.ui.network.UserReciever
import kotlinx.coroutines.launch

class UserViewModel(private val userReciever: UserReciever):ViewModel() {

    val m_response :MutableLiveData<List<UsersItem>> =MutableLiveData()

    fun getUsers(){

        viewModelScope.launch {
            try {
                val response = userReciever.getUsers()
                    m_response.value = response
                Log.d("mainTest", "Success")

            } catch (exception: Exception) {

                Log.d("mainTest", "getmsg- ${exception.message}")
            }

        }
        }
    }
