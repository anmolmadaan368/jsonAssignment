package com.example.jsonassignment.ui.models

data class UsersItem(
    val id: Int,
    val name: String,
    val profileImage: String,
    val qualification: List<String>,
    val subjects: List<String>
)