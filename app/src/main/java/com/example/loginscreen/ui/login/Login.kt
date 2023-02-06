package com.example.loginscreen.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.loginscreen.R
import com.example.loginscreen.ReminderApp
import java.io.InputStream

@Composable
fun Login(navController: NavController) {
    var username by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    val true_username = stringResource(id = R.string.email)
    val true_password = stringResource(id = R.string.password)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Reminder",
            fontSize = 64.sp,
            fontStyle = FontStyle.Italic,
            color = MaterialTheme.colors.secondary
        )

        Spacer(modifier = Modifier.size(128.dp))
        val focusManager = LocalFocusManager.current
        OutlinedTextField(
            value = username,
            onValueChange = { text ->
                username = text
            },
            label = { Text("Enter email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.moveFocus(FocusDirection.Down) },
                onGo = { focusManager.moveFocus(FocusDirection.Down) },
                onNext = { focusManager.moveFocus(FocusDirection.Down) },
                onPrevious = { focusManager.moveFocus(FocusDirection.Down) },
                onSearch = { focusManager.moveFocus(FocusDirection.Down) },
                onSend = { focusManager.moveFocus(FocusDirection.Down) }
            ),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(textColor = MaterialTheme.colors.primary)
        )

        Spacer(modifier = Modifier.size(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { text ->
                password = text
            },
            label = { Text("Enter password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(textColor = MaterialTheme.colors.primary)
        )

        Spacer(modifier = Modifier.size(16.dp))

        ClickableText(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = MaterialTheme.colors.primaryVariant, fontSize = 12.sp)) {
                    append("Forgot Password?")
                }
            },
            onClick = { /* TODO */ }
        )
        Button(
            onClick = {
                if (true_username == username && true_password == password) {
                    navController.navigate("home")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 16.dp)
                .size(54.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
        ) {
            Text(text = "Sign In", color = MaterialTheme.colors.onBackground)
        }

        Row {
            Divider(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically),
                color = MaterialTheme.colors.primaryVariant
            )
            Text(text = "or", color = MaterialTheme.colors.primaryVariant, modifier = Modifier.padding(8.dp, 0.dp))
            Divider(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically),
                color = MaterialTheme.colors.primaryVariant
            )
        }

        Button(
            onClick = {
                navController.navigate("register")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 16.dp)
                .size(56.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.onBackground)
        ) {
            Text(text = "Register", color = MaterialTheme.colors.primary)
        }
    }
}