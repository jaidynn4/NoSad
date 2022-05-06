package com.csci448.jaidynnfohr.alpha_release.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.csci448.jaidynnfohr.alpha_release.R
import com.csci448.jaidynnfohr.alpha_release.viewmodels.NoSadViewModel

@Composable
private fun CreateEditTexts(avm: NoSadViewModel) {
    var nameTextState by remember { mutableStateOf(TextFieldValue("")) }
    val emailTextState = avm.userEmail.value
    val passwordTextState = avm.password.value

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
            value = emailTextState, onValueChange = { avm.setUserEmail(it) },
            placeholder = { Text(text = stringResource(R.string.email_hint)) },
            label = { Text(text = stringResource(R.string.email_hint)) },
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.textFieldColors(focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent)
        )
        Spacer(modifier = Modifier.padding(8.dp))
        TextField(
            value = passwordTextState, onValueChange = { avm.setPassword(it) },
            placeholder = { Text(text = stringResource(R.string.password_hint)) },
            label = { Text(text = stringResource(R.string.password_hint)) },
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.textFieldColors(focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent)
        )
    }
}

@Composable
private fun CreateButtons(onCreate: () -> Unit, onAllReady: () -> Unit, avm: NoSadViewModel) {

    Column {

        Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Button(
                enabled = avm.isValidEmailAndPassword(),
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
fun CreateAccountScreen(
    onCreate: () -> Unit,
    onAlready: () -> Unit,
    avm: NoSadViewModel,
    onCreateSuccess: () -> Unit
) {
    val createSuccess = avm.loginSuccessful.observeAsState()
    LaunchedEffect(createSuccess.value) {
        if (createSuccess.value == true) {
            onCreateSuccess()
        }
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.padding(top = 64.dp))
        Text(
            text = stringResource(id = R.string.create_screen_title),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 16.dp)
        )
        Divider(
            thickness = 2.dp,
            color = colorResource(id = R.color.app_green_color)
        )
        Spacer(modifier = Modifier.padding(16.dp))
        CreateEditTexts(avm)
        Spacer(modifier = Modifier.padding(8.dp))
        CreateButtons(onCreate, onAlready, avm)
    }
}
