package com.example.apitask.modals

import com.google.gson.annotations.SerializedName

data class UserInfo (
    @SerializedName("name" ) var name : String? = null,
    @SerializedName("job"  ) var job  : String? = null
)


