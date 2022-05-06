package com.csci448.jaidynnfohr.alpha_release.ui.screens

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
import com.csci448.jaidynnfohr.alpha_release.viewmodels.NoSadViewModel

@Composable
fun EditTextAndButtons(onForgot: () -> Unit, avm: NoSadViewModel) {
    val emailTextState = avm.userEmail.value
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(
            value = emailTextState, onValueChange = { avm.setUserEmail(it)},
            placeholder = {Text(text = stringResource(R.string.forgot_password_field_hint))},
            label = {Text(text = stringResource(R.string.forgot_password_field_hint))},
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.textFieldColors(focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent)
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Button(
            onClick = {avm.forgotEmailReset()
                      onForgot()},
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.app_green_color),
                contentColor = Color.White
            )
        ) {
            Text(text = stringResource(R.string.reset_password_button_label), fontSize = 14.sp)
        }
    }
}

@Composable
fun ForgotPasswordScreen(
    onForgot: () -> Unit,
    avm: NoSadViewModel) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = stringResource(R.string.forgot_password_title), color = colorResource(id = R.color.app_green_color), fontSize = 20.sp)
        Spacer(modifier = Modifier.padding(24.dp))
        EditTextAndButtons(onForgot, avm)
    }
}
