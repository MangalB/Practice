package com.example.practice.api

import retrofit2.http.GET

// A networking API used within the app.
//
// Implement the API using retrofit, ktor or any networking library of your choice
// without modifying this API. See `RetrofitAPI.kt` template to start with.
//
// Note: The concrete implementation of this API should not contain anything that's unrelated
//       to this task. There is no plan to expand this project therefore features that are not
//       related to the task should be avoided.
//       i.e. Do not add support for fetching images or anything unrelated to the task at hand.
//
interface API {

    // Execute asynchronous fetch of users list and callback with `success` or `failure` accordingly
    // Caller can choose to exclude a given user by an ID in `excludingUserWithID` parameter.
    // In this case, filter the given ID from the response
    //
    // Note: The task requires result of this fetch to always be returned in reverse order
    //       of the raw JSON response.
    //

    @GET("/users")
    suspend fun fetchUsersList (): List<UserModel>
}

