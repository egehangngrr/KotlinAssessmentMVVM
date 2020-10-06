package com.egehangungor.usergenerator.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Json4Kotlin_Base (

	@SerializedName("results") val results : List<Results>?,
	@SerializedName("info") val info : Info?
) : Serializable