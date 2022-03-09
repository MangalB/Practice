package com.example.practice.api

sealed class DataState{
    object Loading: DataState()
    data class Success(val users: List<UserModel>): DataState()
    data class Failure(val errorMessage: String): DataState()
}
