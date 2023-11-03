package com.example.okhttpexample.models

data class UserModel(
    val data: List<Datum>
)


data class Datum(
    val email: String,
    val first_name: String,
    val avatar: String
)