package com.example.retrofitandmoshi.data.userdata

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

class DataAdapter {
    @ToJson
    fun dataToJson(dataClass: DataClass) : JsonClass {
        return JsonClass(
            dataClass.id,
            dataClass.name,
            dataClass.userName,
            dataClass.email,
            dataClass.address,
            dataClass.phone,
            dataClass.website,
            dataClass.company
        )
    }

    @FromJson
    fun jsonToData(jsonClass: JsonClass) : DataClass {
        return DataClass(
            jsonClass.id,
            jsonClass.name,
            jsonClass.userName,
            jsonClass.email,
            jsonClass.address,
            jsonClass.phone,
            jsonClass.website,
            jsonClass.company
        )
    }
}