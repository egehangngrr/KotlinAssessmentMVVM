package com.egehangungor.usergenerator.model
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Street (

	@SerializedName("number") val number : Int,
	@SerializedName("name") val name : String
) : Serializable