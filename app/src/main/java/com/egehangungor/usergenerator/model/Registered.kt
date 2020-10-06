package com.egehangungor.usergenerator.model
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Registered (

	@SerializedName("date") val date : String,
	@SerializedName("age") val age : Int
) : Serializable