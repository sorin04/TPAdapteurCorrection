package com.michael.retrofitcall.pojo

import com.google.gson.annotations.SerializedName

data class EtuItem(

	@SerializedName("image")
	val image: String,

	@SerializedName("firstname")
	val firstname: String,

	@SerializedName("id")
	val id: Int,

	@SerializedName("age")
	val age: String,

	@SerializedName("lastname")
	val lastname: String
){

	override fun toString(): String {
		return "($id) $firstname $lastname $age\n"
	}
}