package com.example.loginscreen.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

var counter = 2

@Composable
fun Home(navController: NavController) {
    var reminders by rememberSaveable {
        mutableStateOf(listOf<String>("Reminder #1", "Reminder #2"))
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(64.dp)
                .background(color = MaterialTheme.colors.secondary)
        ) {
            /*
            IconButton(
                onClick = {
                    navController.popBackStack()
                },
                modifier = Modifier
                    .fillMaxHeight()
                    .align(Alignment.CenterStart)
                    .padding(8.dp, 0.dp)
            ) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .size(32.dp)
                )
            }*/
            IconButton(
                onClick = {
                    navController.navigate("profile")
                },
                modifier = Modifier
                    .fillMaxHeight()
                    .align(Alignment.CenterEnd)
                    .padding(8.dp, 0.dp)
            ) {
                Icon(
                    Icons.Default.Person,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .size(32.dp)
                )
            }
        }
        LazyColumn {
            items(reminders) { currentReminder ->
                Text(
                    text = currentReminder,
                    fontSize = 26.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp),
                    color = MaterialTheme.colors.primary
                )
                Divider()
            }
        }
    }
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Transparent)
            .padding(16.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.Bottom
    ) {
        Button(
            onClick = {
                counter++
                reminders = reminders + "Reminder #$counter"
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape),
            elevation = ButtonDefaults.elevation(2.dp)
        ) {
            Box() {
                Icon(
                    Icons.Default.Add,
                    contentDescription = null,
                    modifier = Modifier
                        .size(32.dp)
                        .align(Alignment.Center),
                    tint = Color.White
                )
            }
        }
    }
}