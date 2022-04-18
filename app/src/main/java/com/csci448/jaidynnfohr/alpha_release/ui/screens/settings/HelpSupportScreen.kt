package com.csci448.jaidynnfohr.alpha_release.ui.screens.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.csci448.jaidynnfohr.alpha_release.R
import com.csci448.jaidynnfohr.alpha_release.ui.theme.Alpha_ReleaseTheme
import com.csci448.jaidynnfohr.alpha_release.ui.theme.OurGreen

@Composable
fun HelpSupportScreen(
    onBack : () -> Unit
){
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
            text = stringResource(id = R.string.help_support_title),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(16.dp))
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            ){
                Text(text = stringResource(id = R.string.help_blurb), fontSize = 16.sp)
            }
            Spacer(Modifier.height(16.dp))

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Text(text = stringResource(id = R.string.contact_mini_title), fontSize = 16.sp)
            }

            TextButton(onClick = { onContactClick(isEmail = true) }, Modifier.padding(start = 8.dp)) {
                Text(text = stringResource(id = R.string.company_email), fontSize = 16.sp, color = colorResource(
                    id = R.color.app_green_color))
            }
            Surface() {
                TextButton(onClick = { onContactClick(isEmail = false) }, Modifier.padding(start = 8.dp)) {
                    Text(text = stringResource(id = R.string.company_phone), fontSize = 16.sp, color = colorResource(
                        id = R.color.app_green_color
                    ))
                }
            }
            Spacer(Modifier.height(24.dp))
        }
    }
}

private fun onContactClick(isEmail : Boolean = false){
    if(isEmail){
        // Bring up dialog to ask user if they want to use their email -->
        // open up email activity on phone or close dialog
    }
    else{
        // Same thing as email but with a phone
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHelp(){
    HelpSupportScreen {

    }
}