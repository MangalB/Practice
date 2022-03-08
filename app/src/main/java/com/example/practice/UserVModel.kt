package com.example.practice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import api.DataState
import api.RetrofitAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserVModel : ViewModel() {
    val dataState = MutableStateFlow<DataState>(DataState.Loading)
    val userServices = RetrofitAPI.create()

    init {
        loadUsers()
    }

    fun loadUsers(excludingUserWithID: Int? = null) = viewModelScope.launch {
        dataState.value = DataState.Loading
        try {
            val users = withContext(Dispatchers.IO) { userServices.fetchUsersList() }

            dataState.value = DataState.Success(users.filterNot { it.id == excludingUserWithID })
        } catch (e: Exception) {
            dataState.value = DataState.Failure(e.localizedMessage)
        }
    }

}