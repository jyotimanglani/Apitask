package com.example.apitask.files

import android.service.autofill.UserData
import com.example.apitask.modals.Getuser
import com.example.apitask.modals.UserInfo
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface RestApi {
    //@Headers("Content-Type: application/json")

    @POST("api/users")
    fun addUser(@Body userData: UserInfo): Call<UserInfo>

    @GET("api/users/2")
    fun getUser(): Call<Getuser>
}