package com.example.loginscreen.ui.home

import android.graphics.Paint.Align
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.loginscreen.R

@Composable
fun Profile(navController: NavController) {
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
            }
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(256.dp)
                .clip(CircleShape)
                .background(color = Color.Black)
        ) {
            Icon(
                Icons.Default.Person,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center),
                tint = Color.White
            )
        }
        
        Spacer(modifier = Modifier.size(16.dp))

        Text(text = "Name", modifier = Modifier
            .padding(32.dp, 0.dp)
            .align(Alignment.Start), color = MaterialTheme.colors.primary)
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(shape = MaterialTheme.shapes.small)
            .background(color = MaterialTheme.colors.onBackground)
        ) {
            Text(
                text = "Matti Meikäläinen",
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterStart),
                color = MaterialTheme.colors.primary
            )
        }

        Text(text = "Username/email", modifier = Modifier
            .padding(32.dp, 0.dp)
            .align(Alignment.Start), color = MaterialTheme.colors.primary)
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(shape = MaterialTheme.shapes.small)
            .background(color = MaterialTheme.colors.onBackground)
        ) {
            val true_username = stringResource(id = R.string.email)
            Text(
                text = true_username,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterStart),
                color = MaterialTheme.colors.primary
            )
        }


        Button(onClick = { navController.navigate("login") },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
            modifier = Modifier
                .fillMaxWidth()
                .padding(64.dp)
                .size(64.dp)
        ) {
            Text(
                text = "Sign Out",
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                color = MaterialTheme.colors.onBackground
            )
        }

        /*
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(shape = MaterialTheme.shapes.small)
            .background(color = Color.Red)
        ) {
            Text(
                text = "Sign Out",
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterStart),
                color = MaterialTheme.colors.primary
            )
        }*/
    }
}