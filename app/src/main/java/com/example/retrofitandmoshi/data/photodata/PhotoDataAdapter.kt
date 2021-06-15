package com.example.retrofitandmoshi.data.photodata

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

class PhotoDataAdapter {
    @FromJson
    fun JsonToData(photoJson: PhotoJson) : PhotoData {
        return PhotoData(photoJson.albumId, photoJson.id, photoJson.title, photoJson.url, photoJson.thumbnailUrl)
    }

    @ToJson
    fun DataToJson(photoData: PhotoData) : PhotoJson {
        return PhotoJson(photoData.albumId, photoData.id, photoData.title, photoData.imageUrl, photoData.thumbUrl)
    }
}