package com.egehangungor.usergenerator.model
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Timezone (

	@SerializedName("offset") val offset : String,
	@SerializedName("description") val description : String
) : Serializable