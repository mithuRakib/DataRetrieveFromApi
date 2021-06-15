package com.example.retrofitandmoshi.networkUtil

import com.example.retrofitandmoshi.data.photodata.PhotoData
import com.example.retrofitandmoshi.data.photodata.PhotoDataAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

class NetworkPhotoUtil {
    companion object {
        private const val BASE_URL : String = "https://jsonplaceholder.typicode.com/"

        private val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .add(PhotoDataAdapter())
            .build()

        private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    interface PhotoDataInterface {
        @GET("/photos")
        fun getPhotoList():Call<List<PhotoData>>

        @GET("photos/{id}")
        fun getSinglePhoto(@Path("id") id: String):Call<PhotoData>
    }

    object PhotoDataObject {
        val photoDataInterface:PhotoDataInterface by lazy {
            retrofit.create(PhotoDataInterface::class.java)
        }
    }

}