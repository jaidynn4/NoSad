package com.csci448.jaidynnfohr.alpha_release.ui.screens.settings

import android.widget.RadioGroup
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.csci448.jaidynnfohr.alpha_release.R

@Composable
fun NotificationsScreen(
    onBack : () -> Unit
){
    val newsButton = remember{ mutableStateOf(false)}
    val moodButton = remember { mutableStateOf(false)}
    val scriptureButton = remember { mutableStateOf(false)}
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
        Spacer(Modifier.height(16.dp))
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                Modifier.padding(start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = stringResource(R.string.news_button), fontSize = 16.sp)
                Spacer(Modifier.width(16.dp))
                RadioButton(
                    selected = newsButton.value,
                    onClick = { newsButton.value = !newsButton.value },
                )
            }
            Row(
                Modifier.padding(start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = stringResource(R.string.mood_button), fontSize = 16.sp)
                Spacer(Modifier.width(16.dp))
                RadioButton(selected = moodButton.value, onClick = { moodButton.value = !moodButton.value })
            }
            Row(
                Modifier.padding(start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = stringResource(R.string.scripture_button), fontSize = 16.sp)
                Spacer(Modifier.width(16.dp))
                RadioButton(selected = scriptureButton.value, onClick = { scriptureButton.value = !scriptureButton.value })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewNotifications(){
    NotificationsScreen {

    }
}