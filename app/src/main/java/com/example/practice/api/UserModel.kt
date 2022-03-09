package com.example.practice.api

import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("address")
    val address: Address,

    @SerializedName("company")
    val company: Company
) {

    override fun equals(other: Any?): Boolean {
        val otherUser = other as UserModel
        return id == otherUser.id && name.contentEquals(otherUser.name) && email.contentEquals(otherUser.email)
                && address.city.contentEquals(otherUser.address.city) && company.companyName.contentEquals(otherUser.company.companyName)
    }

    class Address(
        @SerializedName("city")
        val city: String
    )

    class Company(
        @SerializedName("name")
        val companyName: String
    )
}