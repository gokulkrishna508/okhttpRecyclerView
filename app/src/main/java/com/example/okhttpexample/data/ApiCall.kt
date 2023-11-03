package com.example.okhttpexample.data

import com.example.okhttpexample.models.UserModel
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.Request

fun fetchUsers(): UserModel {
    val client = OkHttpClient()
    val request = Request.Builder()
        .url("https://reqres.in/api/users?page=1")
        .build()
    return client.newCall(request).execute().use { response ->
        if (!response.isSuccessful) {
            throw java.io.IOException("Unexpected code $response")
        } else {
            val gson = GsonBuilder().create()
            gson.fromJson(response.body?.string(), UserModel::class.java)
        }
    }
}