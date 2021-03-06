package com.csci448.jaidynnfohr.alpha_release.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.csci448.jaidynnfohr.alpha_release.R
import com.csci448.jaidynnfohr.alpha_release.viewmodels.NoSadViewModel

@Composable
fun Settings(
    onAccountClick : () -> Unit,
    onNotificationsClick : () -> Unit,
    onPrivacySecurityClick : () -> Unit,
    onHelpSupportClick : () -> Unit,
    onAboutClick : () -> Unit,
    onBack : () -> Unit,
    onLogout: () -> Unit,
    onLogoutSuccessful: () -> Unit,
    avm: NoSadViewModel
){
    val logged = avm.isLoggedIn.observeAsState()
    LaunchedEffect(logged.value) {
        if(logged.value == false) {
            onLogoutSuccessful()
        }
    }


    Column(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
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
            text = stringResource(id = R.string.settings_screen_title),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(16.dp))
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
                    .padding(start = 16.dp, end = 16.dp)
                    .clickable(onClick = onAccountClick),
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    imageVector = Icons.Rounded.AccountCircle,
                    contentDescription = stringResource(R.string.account_content_desc)
                )
                Spacer(modifier = Modifier.width(16.dp))
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
                    .padding(start = 16.dp, end = 16.dp)
                    .clickable(onClick = onNotificationsClick),
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    imageVector = Icons.Rounded.Notifications,
                    contentDescription = stringResource(id = R.string.notifs_content_desc)
                )
                Spacer(modifier = Modifier.width(16.dp))
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
                    .padding(start = 16.dp, end = 16.dp)
                    .clickable(onClick = onPrivacySecurityClick),
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    imageVector = Icons.Rounded.Lock,
                    contentDescription = stringResource(id = R.string.privacy_security_content_desc)
                )
                Spacer(modifier = Modifier.width(16.dp))
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
                    .padding(start = 16.dp, end = 16.dp)
                    .clickable(onClick = onHelpSupportClick),
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    imageVector = Icons.Rounded.Headset,
                    contentDescription = stringResource(id = R.string.help_support_content_desc)
                )
                Spacer(modifier = Modifier.width(16.dp))
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
                    .padding(start = 16.dp, end = 16.dp)
                    .clickable(onClick = onAboutClick),
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    imageVector = Icons.Rounded.Info,
                    contentDescription = stringResource(id = R.string.about_content_desc)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = stringResource(id = R.string.about_title))
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Rounded.KeyboardArrowRight,
                    contentDescription = stringResource(
                        id = R.string.arrow_desc
                    )
                )
            }
            TextButton(onClick = onLogout , shape = RoundedCornerShape(20.dp)) {
                Text(text = stringResource(R.string.logout_hint), color = colorResource(id = R.color.app_green_color), fontSize = 10.sp)
            }
        }
    }
}
