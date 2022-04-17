package com.csci448.jaidynnfohr.alpha_release.ui.screens.settings

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.NotificationManagerCompat
import com.csci448.jaidynnfohr.alpha_release.R

@Composable
fun NotificationsScreen(
    onBack : () -> Unit
){
    val context = LocalContext.current
    val newsButton = remember{ mutableStateOf(false)}
    val moodButton = remember { mutableStateOf(false)}
    val scriptureButton = remember { mutableStateOf(false)}
    val pushButton = remember {
        mutableStateOf(
            NotificationManagerCompat
                .from(context)
                .areNotificationsEnabled()
        )
    }
    val scriptureAlert = remember{ mutableStateOf(false)}
    val moodAlert = remember{ mutableStateOf(false)}
    val newsAlert = remember{ mutableStateOf(false)}

    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Icon(
                imageVector = Icons.Rounded.KeyboardArrowLeft,
                contentDescription = stringResource(id = R.string.arrow_back_content_desc),
                modifier = Modifier
                    .clickable(onClick = onBack)
                    .size(40.dp),
            )
        }
        Text(
            text = stringResource(id = R.string.notifications_title),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(24.dp))
        Column(
            Modifier
                .fillMaxWidth()
                .height((LocalConfiguration.current.screenHeightDp * 0.3).dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
                    .height(20.dp)
                    .clickable {
                        onChange(
                            pushButton, isPush = true, 0, 0, 0,
                            context = context
                        )
                    },
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = stringResource(R.string.push_button),
                    fontSize = 16.sp
                )
                RadioButton(
                    selected = pushButton.value,
                    onClick = { onChange(pushButton, isPush = true, 0,0,0,
                        context = context) },
                    enabled = true
                )
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
                    .height(20.dp)
                    .clickable { if(!newsButton.value) {
                        newsAlert.value = !newsAlert.value
                    } else newsButton.value = !newsButton.value
                               },
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text =
                stringResource(R.string.news_button),
                    fontSize = 16.sp
                )
                RadioButton(
                    selected = newsButton.value,
                    onClick = {
                        if(!newsButton.value) {
                            newsAlert.value = !newsAlert.value
                        } else newsButton.value = !newsButton.value
                              },
                    enabled = pushButton.value
                )
                if(newsAlert.value){
                    alertProcess(
                        button = newsButton,
                        context = context,
                        channelName = R.string.news_channel_name,
                        channelDescription = R.string.news_channel_description,
                        channelID = R.string.news_channel_id,
                        dialogTitle = R.string.news_dialogue_title,
                        dialogContent = R.string.news_dialogue_content,
                        alert = newsAlert
                    )
                }
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
                    .height(20.dp)
                    .clickable {
                        if (!moodButton.value) {
                            moodAlert.value = !moodAlert.value
                        } else {
                            moodButton.value = !moodButton.value
                        }
                    },
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.mood_button),
                    fontSize = 16.sp
                )
                RadioButton(
                    selected = moodButton.value,
                    onClick = {
                        if(!moodButton.value) {
                            moodAlert.value = !moodAlert.value
                        } else{
                            moodButton.value = !moodButton.value
                        }
                              },
                    enabled = pushButton.value)
                if(moodAlert.value){
                    alertProcess(
                        button = moodButton,
                        context = context,
                        channelName = R.string.mood_channel_name,
                        channelDescription = R.string.mood_channel_description,
                        channelID = R.string.mood_channel_id,
                        dialogTitle = R.string.mood_dialogue_title,
                        dialogContent = R.string.mood_dialogue_content,
                        alert = moodAlert
                    )
                }
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
                    .height(20.dp)
                    .clickable {
                        if (!scriptureButton.value) {
                            scriptureAlert.value = !scriptureAlert.value
                        } else scriptureButton.value = !scriptureButton.value
                    },
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.scripture_button),
                    fontSize = 16.sp
                )
                RadioButton(
                    selected = scriptureButton.value,
                    onClick = {
                                if (!scriptureButton.value) {
                                    scriptureAlert.value = !scriptureAlert.value
                                }
                                else scriptureButton.value = !scriptureButton.value
                              },
                    enabled = pushButton.value,
                )
                if(scriptureAlert.value){
                    alertProcess(
                        button = scriptureButton,
                        context = context,
                        channelName = R.string.scripture_channel_name,
                        channelDescription = R.string.scripture_channel_description,
                        channelID = R.string.scripture_channel_id,
                        dialogTitle = R.string.scripture_dialogue_title,
                        dialogContent = R.string.scriptire_dialogue_content,
                        alert = scriptureAlert
                    )
                }
            }
        }
    }
}

@Composable
private fun alertProcess(
    button : MutableState<Boolean>,
    context: Context,
    channelName: Int,
    channelDescription: Int,
    channelID: Int,
    dialogTitle : Int,
    dialogContent : Int,
    alert : MutableState<Boolean>
){
    AlertDialog(
        onDismissRequest = { },
        confirmButton = {
            TextButton(onClick = {
                onChange(
                    button,
                    channelName = channelName,
                    channelDescription = channelDescription,
                    channelID = channelID,
                    context = context
                )
                alert.value = !alert.value
            }) {
                Text(text="Yes")
            }
        },
        dismissButton = {
            TextButton(onClick = {
                alert.value = !alert.value
                button.value = !button.value
            }) {
                Text(text="No")
            }
        },
        title = { Text(text = stringResource(id = dialogTitle)) },
        text = { Text(text = stringResource(id = dialogContent))}
    )
}

private fun onChange(
    notifChange : MutableState<Boolean>,
    isPush : Boolean = false,
    channelName : Int,
    channelDescription : Int,
    channelID: Int,
    context: Context
){
    if(!isPush){
        createNotificationChannel(
            context = context,
            channelName = channelName,
            channelDescription = channelDescription,
            channelID = channelID
        )
    }
    else{
//        NotificationManagerCompat.from(context).
    }
    notifChange.value = !notifChange.value
}


private fun createNotificationChannel(context: Context, channelName : Int, channelDescription : Int, channelID: Int){
    val importance = NotificationManager.IMPORTANCE_DEFAULT
    val channel = NotificationChannel(context.getString(channelID), context.getString(channelName),importance).apply {
        description = context.getString(channelDescription)
    }
    val notificationManager : NotificationManager = context.getSystemService(
        Context.NOTIFICATION_SERVICE) as NotificationManager
    notificationManager.createNotificationChannel(channel)
}

@Preview(showBackground = true)
@Composable
private fun PreviewNotifications(){
    NotificationsScreen {

    }
}