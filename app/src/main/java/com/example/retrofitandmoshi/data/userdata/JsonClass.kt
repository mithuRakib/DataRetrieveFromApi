package com.example.retrofitandmoshi.data.userdata

import com.squareup.moshi.Json

data class JsonClass(
    val id:Int,
    val name:String,
    @Json(name = "username")
    val userName:String,
    val email:String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company
)
