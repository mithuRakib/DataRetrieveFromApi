package com.example.retrofitandmoshi.data.photodata

import com.squareup.moshi.Json

data class PhotoData(
        val albumId:Int,
        val id:Int,
        val title:String,
        @Json(name = "url")
        val imageUrl:String,
        @Json(name = "thumbnailUrl")
        val thumbUrl:String
)



//{
//    "albumId": 1,
//    "id": 1,
//    "title": "accusamus beatae ad facilis cum similique qui sunt",
//    "url": "https://via.placeholder.com/600/92c952",
//    "thumbnailUrl": "https://via.placeholder.com/150/92c952"
//}