package com.example.retrofitandmoshi.networkUtil

import com.example.retrofitandmoshi.data.userdata.DataAdapter
import com.example.retrofitandmoshi.data.userdata.DataClass
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

class NetworkUtil {
    companion object {
        private const val BASE_URL_SINGLE_POST = "https://jsonplaceholder.typicode.com/"
        private const val BASE_URL_TEN_USERS = "https://jsonplaceholder.typicode.com/users"



        private val moshi = Moshi.Builder()
            .add(DataAdapter())
            .add(KotlinJsonAdapterFactory())
            .build()

        private val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL_SINGLE_POST)
            .build()


    }



    interface DataInterface{
        @GET("/users/{id}")
        suspend fun getSingleUser(@Path("id") id: String): DataClass

        @GET("users")
        suspend fun getListOfUsers():List<DataClass>
    }

    object DataObject{
        val dataInterface:DataInterface by lazy {
            retrofit.create(DataInterface::class.java)
        }
    }
}