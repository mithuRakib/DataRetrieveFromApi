package com.example.retrofitandmoshi.data.photodata

import com.squareup.moshi.Json

data class PhotoJson(
        val albumId:Int,
        val id:Int,
        val title:String,
        val url:String,
        val thumbnailUrl:String
)