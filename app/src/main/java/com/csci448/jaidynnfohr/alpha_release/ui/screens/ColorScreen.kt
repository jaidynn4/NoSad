package com.csci448.jaidynnfohr.alpha_release.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.csci448.jaidynnfohr.alpha_release.R
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.sp


@Composable
fun EmotionsDropDown(){
    val emotionsList = mutableListOf<String>(
        stringResource(R.string.love),
        stringResource(R.string.joy),
        stringResource(R.string.surprise),
        stringResource(R.string.sadness),
        stringResource(R.string.anger),
        stringResource(R.string.fear)
    )

    var emotion: String by remember { mutableStateOf(emotionsList[0]) }
    var expanded by remember { mutableStateOf(false)}


    Box(Modifier.fillMaxWidth(),contentAlignment = Alignment.Center) {
        Row(
            Modifier
                .padding(24.dp)
                .clickable {
                    expanded = !expanded
                }
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) { // Anchor view
            Text(text = emotion,fontSize = 18.sp,modifier = Modifier.padding(end = 8.dp)) // Country name label
            Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "")

            //
            DropdownMenu(expanded = expanded, onDismissRequest = {
                expanded = false
            }) {
                emotionsList.forEach{ emotionChoice->
                    DropdownMenuItem(onClick = {
                        expanded = false
                        emotion = emotionChoice
                    }) {
                        Text(text = emotionChoice)
                    }
                }
            }
        }
    }

}