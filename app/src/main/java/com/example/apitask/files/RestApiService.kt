package com.example.apitask.files

import android.service.autofill.UserData
import android.util.Log
import android.widget.Toast
import com.example.apitask.modals.Getuser
import com.example.apitask.modals.UserInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class RestApiService {
    fun addUser(userData: UserInfo, onResult: (UserInfo?) -> Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.addUser(userData).enqueue(
            object : Callback<UserInfo> {
                override fun onFailure(call: Call<UserInfo>, t: Throwable) {
                    onResult(null)
                }

                override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {
                    val addedUser = response.body()
                    onResult(addedUser)
                }
            }
        )
    }

    fun getPost(){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.getUser().enqueue(
            object : Callback<Getuser> {
                override fun onResponse(call: Call<Getuser>, response: Response<Getuser>) {
                   Log.d("call ", call.toString())
                   Log.d("response  ", response.toString())
                }

                override fun onFailure(call: Call<Getuser>, t: Throwable) {
                }

            }
        )
    }
}
