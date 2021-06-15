package com.example.retrofitandmoshi.viewmodel

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitandmoshi.data.userdata.DataClass
import com.example.retrofitandmoshi.networkUtil.NetworkUtil
import kotlinx.coroutines.launch
import java.lang.Exception
import kotlin.random.Random

class ActivityViewModel : ViewModel() {
    private val _response = MutableLiveData<String>()
    val response : LiveData<String>
        get() = _response

    private val _responseData = MutableLiveData<DataClass>()
    val responseData : LiveData<DataClass>
        get() = _responseData

    private val _id = MutableLiveData<String>()
    private val id : LiveData<String>
        get() = _id

    private val _listUser = MutableLiveData<List<DataClass>>()
    val listUser:LiveData<List<DataClass>>
        get() = _listUser

    init {
//        _id.value = "2"
        val timer = object : CountDownTimer(60000, 5000) {
            override fun onTick(millisUntilFinished: Long) {
                _id.value = Random.nextInt(1, 10).toString()
                Log.d("ViewModel", _id.value!!)
//                getResponse()
            }

            override fun onFinish() {
                _id.value = "1"
            }

        }
        timer.start()
        getListResponse()
    }

    private fun getListResponse(){
        viewModelScope.launch {
            try {
                _listUser.value = NetworkUtil.DataObject.dataInterface.getListOfUsers()
            } catch (e:Exception) {
                Log.d("ViewModel: ", "Exception ${e.message}")
            }
        }
    }

    companion object {
        val list = mutableListOf<DataClass>()
    }

}