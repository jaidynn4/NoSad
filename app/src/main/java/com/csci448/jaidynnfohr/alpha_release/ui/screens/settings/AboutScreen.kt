package com.csci448.jaidynnfohr.alpha_release.ui.screens.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
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
fun AboutScreen(
    onBack : () -> Unit
){
    LazyColumn(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
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
                text = stringResource(id = R.string.about_title),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(16.dp))
            Column(
                Modifier
                    .width((LocalConfiguration.current.screenWidthDp * .8).dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.about_blurb_one),
                    fontSize = 16.sp
                )
                Spacer(Modifier.height(16.dp))
                Text(
                    text = stringResource(R.string.about_blurb_two),
                    fontSize = 16.sp
                )
                Spacer(Modifier.height(16.dp))
                Text(
                    text = stringResource(R.string.about_disclaimer),
                    fontSize = 16.sp
                )
                Spacer(Modifier.height(24.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewAboutScreen(){
    AboutScreen {

    }
}