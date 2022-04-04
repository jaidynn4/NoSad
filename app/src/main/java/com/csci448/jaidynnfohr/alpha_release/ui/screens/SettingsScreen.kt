package com.csci448.jaidynnfohr.alpha_release.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.csci448.jaidynnfohr.alpha_release.R

@Composable
fun Settings(){
    Column(
        Modifier.fillMaxHeight().fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.settings_screen_title),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Column(
            Modifier
                .fillMaxWidth()
                .height((LocalConfiguration.current.screenHeightDp * 0.5).dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)
                    .clickable { },
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    imageVector = Icons.Rounded.AccountCircle,
                    contentDescription = stringResource(R.string.account_content_desc)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = stringResource(id = R.string.my_account_title))
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Rounded.KeyboardArrowRight,
                    contentDescription = stringResource(
                        id = R.string.arrow_desc
                    )
                )
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)
                    .clickable { },
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    imageVector = Icons.Rounded.Notifications,
                    contentDescription = stringResource(id = R.string.notifs_content_desc)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = stringResource(id = R.string.notifications_title))
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Rounded.KeyboardArrowRight,
                    contentDescription = stringResource(
                        id = R.string.arrow_desc
                    )
                )
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)
                    .clickable { },
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    imageVector = Icons.Rounded.RemoveRedEye,
                    contentDescription = stringResource(id = R.string.appearance_content_desc)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = stringResource(id = R.string.appearance_title))
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Rounded.KeyboardArrowRight,
                    contentDescription = stringResource(
                        id = R.string.arrow_desc
                    )
                )
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)
                    .clickable { },
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    imageVector = Icons.Rounded.Lock,
                    contentDescription = stringResource(id = R.string.privacy_security_content_desc)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = stringResource(id = R.string.privacy_security_title))
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Rounded.KeyboardArrowRight,
                    contentDescription = stringResource(
                        id = R.string.arrow_desc
                    )
                )
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)
                    .clickable { },
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    imageVector = Icons.Rounded.Headset,
                    contentDescription = stringResource(id = R.string.help_support_content_desc)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = stringResource(id = R.string.help_support_title))
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Rounded.KeyboardArrowRight,
                    contentDescription = stringResource(
                        id = R.string.arrow_desc
                    )
                )
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)
                    .clickable { },
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    imageVector = Icons.Rounded.Info,
                    contentDescription = stringResource(id = R.string.about_content_desc)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = stringResource(id = R.string.about_title))
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Rounded.KeyboardArrowRight,
                    contentDescription = stringResource(
                        id = R.string.arrow_desc
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSettings(){
    Settings()
}