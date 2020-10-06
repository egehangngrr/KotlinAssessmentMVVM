package com.egehangungor.usergenerator.service

import com.egehangungor.usergenerator.model.Json4Kotlin_Base
import retrofit2.http.GET

interface UserAPI {
    @GET("api/?results=20")
    fun getUsers(): retrofit2.Call<Json4Kotlin_Base>
}