package api

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
    class Address(
        @SerializedName("city")
        val city: String
    )

    class Company(
        @SerializedName("name")
        val companyName: String
    )
}