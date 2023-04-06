package com.example.apitask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.apitask.files.RestApiService
import com.example.apitask.modals.UserInfo

class MainActivity : AppCompatActivity() {

    val apiService = RestApiService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val postButton = findViewById<Button>(R.id.post_btn)

        postButton.setOnClickListener {
            addDummyUser()
            apiService.getPost()


        }
    }

    private fun addDummyUser() {

        val userInfo = UserInfo(
            name = "Jyoti",
            job = "Developer"
        )
        apiService.addUser(userInfo) {
            if (it != null) {
                it.job?.let { it1 -> Log.d("value", it1) }
            }
        }

    }

}


