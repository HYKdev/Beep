package com.example.beep.data.api

import com.example.beep.data.dto.DataModel
import com.example.beep.data.dto.RetrofitTestGetResponse
import com.example.beep.data.dto.RetrofitTestResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitApi {
    @POST("users")
    fun postDataOriginal(@Body dataModel: DataModel?): Call<DataModel?>?

    @POST("users")
    suspend fun postData(@Body dataModel: DataModel?): RetrofitTestResponse

    @GET("users/2")
    suspend fun getData(): RetrofitTestGetResponse
}