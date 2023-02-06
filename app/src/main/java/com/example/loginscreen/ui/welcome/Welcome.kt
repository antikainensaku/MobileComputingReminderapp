package com.example.loginscreen.ui.welcome

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Welcome(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            text = "Reminder",
            fontSize = 64.sp,
            fontStyle = FontStyle.Italic,
            color = MaterialTheme.colors.secondary
        )
        Spacer(modifier = Modifier.size(258.dp))
        OutlinedButton(
            onClick = { navController.navigate("login") },
            modifier = Modifier
                .fillMaxWidth()
                .size(64.dp)
        ) {
            Text(text = "Log In")
        }

        Spacer(modifier = Modifier.size(16.dp))

        Text(
            text = "Don't have an account? Sign up.",
            fontSize = 12.sp,
            color = MaterialTheme.colors.primaryVariant,
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.Start)
        )

        OutlinedButton(
            onClick = { navController.navigate("register")},
            modifier = Modifier
                .fillMaxWidth()
                .size(64.dp)
        ) {
            Text(text = "Register")
        }

        Spacer(modifier = Modifier.size(32.dp))
    }
}