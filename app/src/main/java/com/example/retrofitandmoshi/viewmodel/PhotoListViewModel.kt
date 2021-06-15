package com.example.retrofitandmoshi.viewmodel

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitandmoshi.data.photodata.PhotoData
import com.example.retrofitandmoshi.networkUtil.NetworkPhotoUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.random.Random

class PhotoListViewModel : ViewModel() {
    private val _photoList = MutableLiveData<List<PhotoData>>()
    val photoList:LiveData<List<PhotoData>>
        get() = _photoList

    private val _photo = MutableLiveData<PhotoData>()
    val photo:LiveData<PhotoData>
        get() = _photo

    init {
        getPhotoData()

        val timer = object : CountDownTimer(120000, 5000){
            override fun onTick(millisUntilFinished: Long) {
                val random = Random.nextInt(1, 5000).toString()
                getSingleImageRandomly(random)
                Log.d("ViewModel::", random)
            }

            override fun onFinish() {
            }

        }

        timer.start()
    }

    private fun getSingleImageRandomly(id:String){
        NetworkPhotoUtil.PhotoDataObject.photoDataInterface.getSinglePhoto(id).enqueue(
            object : Callback<PhotoData> {
                override fun onResponse(call: Call<PhotoData>, response: Response<PhotoData>) {
                    _photo.value = response.body()
                }

                override fun onFailure(call: Call<PhotoData>, t: Throwable) {
                    Log.d("ViewModel::", t.message.toString())
                }

            }
        )
    }

    private fun getPhotoData(){
        NetworkPhotoUtil.PhotoDataObject.photoDataInterface.getPhotoList().enqueue(
            object : Callback<List<PhotoData>>{
                override fun onResponse(
                    call: Call<List<PhotoData>>,
                    response: Response<List<PhotoData>>
                ) {
                    response.let {
                        _photoList.value = it.body()
                    }
                }

                override fun onFailure(call: Call<List<PhotoData>>, t: Throwable) {

                }

            }
        )
    }
}