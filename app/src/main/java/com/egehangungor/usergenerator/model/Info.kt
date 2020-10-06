package com.egehangungor.usergenerator.model



import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Info (

	@SerializedName("seed") val seed : String,
	@SerializedName("results") val results : Int,
	@SerializedName("page") val page : Int,
	@SerializedName("version") val version : Double
) : Serializable