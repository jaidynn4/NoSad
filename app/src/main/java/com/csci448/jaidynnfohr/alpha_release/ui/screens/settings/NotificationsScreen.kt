package com.csci448.jaidynnfohr.alpha_release.ui.screens.settings

import android.app.Activity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.ContextWrapper
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.csci448.jaidynnfohr.alpha_release.MainActivity
import com.csci448.jaidynnfohr.alpha_release.R
import com.csci448.jaidynnfohr.alpha_release.ui.navigation.specs.AddMoodScreenSpec
import com.csci448.jaidynnfohr.alpha_release.ui.navigation.specs.DetailScreenSpec
import com.csci448.jaidynnfohr.alpha_release.ui.navigation.specs.HomeScreenSpec
import com.csci448.jaidynnfohr.alpha_release.ui.navigation.specs.ResourcesScreenSpec


val newsState : Boolean = false
val moodState : Boolean = false
val scriptureState : Boolean = false
val newsAlertState : Boolean = false
val moodAlertState : Boolean = false
val scriptureAlertState : Boolean = false

@Composable
fun NotificationsScreen(
    onBack : () -> Unit,
){
    val context = LocalContext.current
    val newsButton = rememberSaveable{ mutableStateOf(newsState) }
    val moodButton = rememberSaveable{ mutableStateOf(moodState) }
    val scriptureButton = rememberSaveable{ mutableStateOf(scriptureState) }
    val pushButton = remember {
        mutableStateOf(
            NotificationManagerCompat
                .from(context)
                .areNotificationsEnabled()
        )
    }
    val scriptureAlert = rememberSaveable{ mutableStateOf(newsAlertState) }
    val moodAlert = rememberSaveable{ mutableStateOf(moodAlertState) }
    val newsAlert = rememberSaveable{ mutableStateOf(scriptureAlertState) }

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
                            context = context, screen = HomeScreenSpec.route
                        )
                    },
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = stringResource(R.string.push_button),
                    fontSize = 16.sp
                )
                Switch(
                    checked = pushButton.value,
                    onCheckedChange = {
                        onChange(pushButton, isPush = true, 0,0,0,
                        context = context, screen = HomeScreenSpec.route)
                              },
                    enabled = true
                )
            }
            if(pushButton.value) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp)
                        .height(20.dp)
                        .clickable {
                            if (!newsButton.value) {
                                newsAlert.value = !newsAlert.value
                            } else newsButton.value = !newsButton.value
                        },
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text =
                        stringResource(R.string.news_button),
                        fontSize = 16.sp
                    )
                    Switch(
                        checked = newsButton.value,
                        onCheckedChange = {
                            if (!newsButton.value) {
                                newsAlert.value = !newsAlert.value
                            } else newsButton.value = !newsButton.value
                        },
                        enabled = pushButton.value
                    )
                    if (newsAlert.value) {
                        alertProcess(
                            button = newsButton,
                            context = context,
                            channelName = R.string.news_channel_name,
                            channelDescription = R.string.news_channel_description,
                            channelID = R.string.news_channel_id,
                            dialogTitle = R.string.news_dialogue_title,
                            dialogContent = R.string.news_dialogue_content,
                            alert = newsAlert,
                            screen = ResourcesScreenSpec.route
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
                    Switch(
                        checked = moodButton.value,
                        onCheckedChange = {
                            if (!moodButton.value) {
                                moodAlert.value = !moodAlert.value
                            } else {
                                moodButton.value = !moodButton.value
                            }
                        },
                        enabled = pushButton.value
                    )
                    if (moodAlert.value) {
                        alertProcess(
                            button = moodButton,
                            context = context,
                            channelName = R.string.mood_channel_name,
                            channelDescription = R.string.mood_channel_description,
                            channelID = R.string.mood_channel_id,
                            dialogTitle = R.string.mood_dialogue_title,
                            dialogContent = R.string.mood_dialogue_content,
                            alert = moodAlert,
                            screen = AddMoodScreenSpec.route
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
                    Switch(
                        checked = scriptureButton.value,
                        onCheckedChange = {
                            if (!scriptureButton.value) {
                                scriptureAlert.value = !scriptureAlert.value
                            } else scriptureButton.value = !scriptureButton.value
                        },
                        enabled = pushButton.value,
                    )
                    if (scriptureAlert.value) {
                        alertProcess(
                            button = scriptureButton,
                            context = context,
                            channelName = R.string.scripture_channel_name,
                            channelDescription = R.string.scripture_channel_description,
                            channelID = R.string.scripture_channel_id,
                            dialogTitle = R.string.scripture_dialogue_title,
                            dialogContent = R.string.scriptire_dialogue_content,
                            alert = scriptureAlert,
                            screen = ResourcesScreenSpec.route
                        )
                    }
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
    alert : MutableState<Boolean>,
    screen: String
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
                    context = context,
                    screen = screen
                )
                alert.value = !alert.value
            }) {
                Text(text="Yes", color = Color.Green)
            }
        },
        dismissButton = {
            TextButton(onClick = {
                alert.value = !alert.value
                button.value = !button.value
            }) {
                Text(text="No", color = Color.Green)
            }
        },
        title = { Text(text = stringResource(id = dialogTitle), color = Color.Green) },
        text = { Text(text = stringResource(id = dialogContent), color = Color.Green)}
    )
}

private fun onChange(
    notifChange : MutableState<Boolean>,
    isPush : Boolean = false,
    channelName : Int,
    channelDescription : Int,
    channelID: Int,
    context: Context,
    screen: String
){
//    when {
//        ContextCompat.checkSelfPermission(
//            context,
//            Manifest.permission.ACCESS_NOTIFICATION_POLICY) == PackageManager.PERMISSION_GRANTED -> {
//                // do nothing
//        }
//        context.getActivity()?.let { ActivityCompat.shouldShowRequestPermissionRationale(it, Manifest.permission.ACCESS_NOTIFICATION_POLICY) } -> {
//
//        }
//        else -> requestPermissionLauncher.launch(
//            Manifest.permission.REQUESTED_PERMISSION
//
//        )
//
//    }
    if(!isPush) {
        createNotificationChannel(
            context = context,
            channelName = channelName,
            channelDescription = channelDescription,
            channelID = channelID,
            screen = screen
        )
    }

    notifChange.value = !notifChange.value

}


private fun createNotificationChannel(context: Context, channelName : Int, channelDescription : Int, channelID: Int, screen : String){
    val importance = NotificationManager.IMPORTANCE_DEFAULT
    val channel = NotificationChannel(context.getString(channelID), context.getString(channelName),importance).apply {
        description = context.getString(channelDescription)
        enableLights(true)
        lightColor = android.graphics.Color.BLUE
        setShowBadge(true)
    }
    val notificationManager = NotificationManagerCompat.from(context)
    notificationManager.createNotificationChannel(channel)

    val pendingIntent = MainActivity.createPendingIntent(context, screen)

    val notification = NotificationCompat.Builder(context,context.getString(channelID))
        .setSmallIcon(android.R.drawable.ic_dialog_map)
        .setContentTitle(context.resources.getString(channelName))
        .setContentText(context.resources.getString(channelDescription))
        .setAutoCancel(true)
        .setContentIntent(pendingIntent)
        .build()

    notificationManager.notify(channelID,notification)
}

private fun Context.getActivity() : Activity? = when (this) {
    is Activity -> this
    is ContextWrapper -> baseContext.getActivity()
    else -> null
}

@Preview(showBackground = true)
@Composable
private fun PreviewNotifications(){
    NotificationsScreen {

    }
}