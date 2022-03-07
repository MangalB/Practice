package com.example.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import api.UserModel


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
                LazyColumn(contentPadding = PaddingValues(15.dp)) {
                    items((1..100).toList()) { row ->
                        Text("Row: $row", color = Color.Magenta)
                    }
                }
            }
        }
    }



    @Composable
    fun ListUsers(users: List<UserModel>) {
        LazyColumn(modifier = Modifier.fillMaxHeight()) {
            items(items = users) { item ->
                Row(modifier = Modifier.padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically) {

                    Box(modifier = Modifier
                        .background(Color.Black, CircleShape)
                        .size(50.dp),
                        contentAlignment = Alignment.Center ){
                        Text(
                            text = item.name.substring(0, 1),
                            color = Color.White,
                            fontSize = 26.sp,
                            fontWeight = FontWeight.Bold)
                    }
                    Column(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(start = 6.dp)
                    ) {
                        Text(
                            text = item.name,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black)
                        Text(
                            text = item.name, fontSize = 16.sp,
                            color = Color.Black,
                            modifier = Modifier.padding(top = 2.dp))
                    }
                }
            }
        }
    }

    fun getDummyData():List<UserModel>{
        val list = mutableListOf<UserModel>()
        for(i in 1..5){
            list.add(UserModel(i, "name $i", "email $i", UserModel.Address("add $i"), UserModel.Company("company $i")))
        }
        return list
    }

    @Preview
    @Composable
    fun UserPreview(){
        LazyColumn(modifier = Modifier.fillMaxWidth().fillMaxHeight() ) {

            items(items = getDummyData()) { user ->

                Surface(modifier = Modifier.padding(4.dp).fillMaxWidth(), shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
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
                                text = "02",
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
