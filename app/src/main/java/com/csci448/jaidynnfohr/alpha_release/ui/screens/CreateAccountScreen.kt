package com.csci448.jaidynnfohr.alpha_release.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.csci448.jaidynnfohr.alpha_release.R

@Composable
private fun CreateEditTexts() {
    var nameTextState by remember { mutableStateOf(TextFieldValue("")) }
    var emailTextState by remember { mutableStateOf(TextFieldValue("")) }
    var passwordTextState by remember { mutableStateOf(TextFieldValue("")) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        TextField(
            value = nameTextState, onValueChange = { it -> nameTextState = it},
            placeholder = { Text(text = stringResource(R.string.name_hint)) },
            label = { Text(text = stringResource(R.string.name_hint)) },
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.textFieldColors(focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent)
        )
        Spacer(modifier = Modifier.padding(8.dp))
        TextField(
            value = emailTextState, onValueChange = { it -> emailTextState = it },
            placeholder = { Text(text = stringResource(R.string.email_hint)) },
            label = { Text(text = stringResource(R.string.email_hint)) },
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.textFieldColors(focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent)
        )
        Spacer(modifier = Modifier.padding(8.dp))
        TextField(
            value = passwordTextState, onValueChange = { it -> passwordTextState = it },
            placeholder = { Text(text = stringResource(R.string.password_hint)) },
            label = { Text(text = stringResource(R.string.password_hint)) },
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.textFieldColors(focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent)
        )
    }
}

@Composable
private fun CreateButtons(onCreate: () -> Unit, onAllReady: () -> Unit) {

    Column {

        Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Button(
                onClick = onCreate,
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.app_green_color),
                    contentColor = Color.White
                )
            ) {
                Text(text = stringResource(R.string.signup_button_hint), fontSize = 14.sp)
            }
        }

        Spacer(modifier = Modifier.padding(8.dp))
        TextButton(
            onClick = onAllReady,
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(text = stringResource(R.string.signin_button_label), color = colorResource(id = R.color.app_green_color), fontSize = 10.sp)
        }
    }
}

@Composable
fun CreateAccountScreen(onCreate: () -> Unit, onAlready: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = stringResource(R.string.create_screen_title), fontSize = 20.sp, color = colorResource(id = R.color.app_green_color))
        Spacer(modifier = Modifier.padding(24.dp))
        CreateEditTexts()
        Spacer(modifier = Modifier.padding(8.dp))
        CreateButtons(onCreate, onAlready)
    }
}
