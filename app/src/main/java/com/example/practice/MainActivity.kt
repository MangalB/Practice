package com.example.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import api.DataState
import api.UserModel
import androidx.compose.runtime.getValue


// TODO: Display list of users with the user information mentioned in the assignment
// Note: A nice looking UI is appreciated but clean code is more important

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.LightGray,
                contentColor = Color.Black
            ) {
                MainView()
            }
        }
    }

    @Composable
    private fun MainView() {
        val viewModel by viewModels<UserVModel>()
        val state by viewModel.dataState.collectAsState()
        when (state) {
            DataState.Loading -> {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator()
                }
            }
            is DataState.Failure -> {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Text(text = "Something went wrong...",fontSize = 16.sp)
                }
            }
            is DataState.Success -> {
                val users = (state as DataState.Success).users
                UserListScreen(users, viewModel)
            }
        }
    }

    fun getDummyData():List<UserModel>{
        val list = mutableListOf<UserModel>()
        for(i in 1..30){
            list.add(UserModel(i, "name $i", "email $i", UserModel.Address("add $i"), UserModel.Company("company $i")))
        }
        return list
    }

    @Composable
    fun UserListScreen(users: List<UserModel>, viewModel: UserVModel){
        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight() ) {

            items(items = users) { user ->

                Surface(modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth().clickable { viewModel.loadUsers(user.id)  }, shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(
                            modifier = Modifier
                                .background(Color.Black, CircleShape)
                                .size(50.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "${user.id}",
                                color = Color.White,
                                fontSize = 26.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Column(
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .padding(start = 6.dp)
                        ) {
                            Text(
                                text = user.name,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                            Text(
                                text = user.email, fontSize = 16.sp,
                                color = Color.Black,
                                modifier = Modifier.padding(top = 2.dp)
                            )
                            Text(
                                text =user.address.city, fontSize = 16.sp,
                                color = Color.Black,
                                modifier = Modifier.padding(top = 2.dp)
                            )
                            Text(
                                text = user.company.companyName, fontSize = 16.sp,
                                color = Color.Black,
                                modifier = Modifier.padding(top = 2.dp)
                            )
                        }
                    }
                }
            }
        }
    }

}
