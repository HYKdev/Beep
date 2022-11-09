package com.example.beep.network.api

import com.example.beep.data.dto.auth.*
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("user/signup")
    suspend fun signUp(@Body request: SignUpRequest): SignUpResponse

    @POST("user/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse

}