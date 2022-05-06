package com.csci448.jaidynnfohr.alpha_release.ui

import androidx.compose.foundation.layout.*
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
import com.csci448.jaidynnfohr.alpha_release.viewmodels.NoSadViewModel
import kotlinx.coroutines.launch

@Composable
private fun Buttons(
    onLogin: () -> Unit,
    onCreateAccount: () -> Unit,
    avm: NoSadViewModel
) {

    Column {
        Spacer(modifier = Modifier.padding(20.dp))
        Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Button(
                enabled = avm.isValidEmailAndPassword(),
              onClick = onLogin ,
              shape = RoundedCornerShape(20.dp),
              colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.app_green_color),
                    contentColor = Color.White
              )
            ) {
                Text(text = stringResource(R.string.login_button_label), fontSize = 14.sp)
            }
        }

        Spacer(modifier = Modifier.padding(8.dp))
        TextButton(onClick = onCreateAccount , shape = RoundedCornerShape(20.dp)) {
            Text(text = stringResource(R.string.signup_button_label), color = colorResource(id = R.color.app_green_color), fontSize = 10.sp)
        }
    }
}

@Composable
fun textFields(
    onForget: () -> Unit,
    avm: NoSadViewModel,
    onLogin: () -> Unit,
    onCreateAccount: () -> Unit
) {

    val emailTextState = avm.userEmail.value
    val passwordTextState = avm.password.value
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(
            value = emailTextState, onValueChange = { avm.setUserEmail(it)},
            placeholder = {Text(text = stringResource(R.string.email_hint))},
            label = {Text(text = stringResource(R.string.email_hint))},
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.textFieldColors(focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent)
        )
        Spacer(modifier = Modifier.padding(8.dp))
        TextField(
            value = passwordTextState, onValueChange = { avm.setPassword(it)},
            placeholder = {Text(text = stringResource(R.string.password_hint))},
            label = {Text(text = stringResource(R.string.password_hint))},
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.textFieldColors(focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent)
            )
        Column(modifier = Modifier.align(Alignment.End)) {
          TextButton(onClick = onForget) {
                Text(text = stringResource(R.string.forgot_password_button_label), fontSize = 10.sp, color = colorResource(id = R.color.app_green_color))
           }
        }
    }
}

@Composable
fun LoginScreen(
    onLogin: () -> Unit,
    onCreateAccount: () -> Unit,
    onForget: () -> Unit,
    avm: NoSadViewModel,
    onLoginSuccess: () -> Unit,
    loginSuccessful: State<Boolean?>
) {
    val scope = rememberCoroutineScope()
    LaunchedEffect(loginSuccessful.value) {
        if (loginSuccessful.value == true) {
            onLoginSuccess()
        }
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = stringResource(R.string.login_title), color = colorResource(id = R.color.app_green_color), fontSize = 20.sp)
        Spacer(modifier = Modifier.padding(24.dp))
        textFields(onForget = onForget, avm = avm, onLogin, onCreateAccount )
        Buttons(onLogin, onCreateAccount, avm = avm)
    }
}

//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun LoginScreenPreview() {
//    NoSad_Scaffold { LoginScreen()}
//}
