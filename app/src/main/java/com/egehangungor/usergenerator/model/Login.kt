package com.egehangungor.usergenerator.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Login (

	@SerializedName("uuid") val uuid : String,
	@SerializedName("username") val username : String,
	@SerializedName("password") val password : String,
	@SerializedName("salt") val salt : String,
	@SerializedName("md5") val md5 : String,
	@SerializedName("sha1") val sha1 : String,
	@SerializedName("sha256") val sha256 : String
) : Serializable