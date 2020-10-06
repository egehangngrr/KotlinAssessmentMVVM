package com.egehangungor.usergenerator.model
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Picture (

	@SerializedName("large") val large : String,
	@SerializedName("medium") val medium : String,
	@SerializedName("thumbnail") val thumbnail : String
) : Serializable