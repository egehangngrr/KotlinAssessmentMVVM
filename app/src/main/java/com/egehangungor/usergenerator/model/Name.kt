package com.egehangungor.usergenerator.model
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Name (

	@SerializedName("title") val title : String,
	@SerializedName("first") val first : String,
	@SerializedName("last") val last : String
) : Serializable