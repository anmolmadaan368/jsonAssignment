package com.example.jsonassignment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jsonassignment.R
import com.example.jsonassignment.ui.ViewModel.UserViewModel
import com.example.jsonassignment.ui.ViewModel.UserViewModelFactory
import com.example.jsonassignment.ui.models.Users
import com.example.jsonassignment.ui.models.UsersItem
import com.example.jsonassignment.ui.network.UserReciever
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
  private val userReciever:UserReciever = UserReciever()
    private lateinit var usersAdapter: UsersAdapter
    private lateinit var userViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()

        val viewModelFactory = UserViewModelFactory(userReciever)
        userViewModel =ViewModelProvider(this,viewModelFactory)[UserViewModel::class.java]
        userViewModel.getUsers()
        userViewModel.m_response.observe(this, Observer {
            usersAdapter.setUserData(it as ArrayList<UsersItem>)
            recyclerView.visibility = View.VISIBLE
        })


    }

  private suspend fun fetchUsers(){
        val usersFetchJob = Job()

//        val errorHandler = CoroutineExceptionHandler{
//            coroutineContext, throwable ->
//            throwable.printStackTrace()
//            Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()
//        }
//
//        val scope = CoroutineScope(usersFetchJob + Dispatchers.Main)
//        scope.launch (errorHandler){
//            //fetched data
//
//        }

        //val users = userReciever.getUsers()
        //Log.d("maintest", "${users.size} ")

        //render data in recycler view
        //renderData(users)
    }



    private fun initRecyclerView(){

        usersAdapter = UsersAdapter(this, ArrayList())

        recyclerView.apply {

        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        adapter = usersAdapter
    }}
}