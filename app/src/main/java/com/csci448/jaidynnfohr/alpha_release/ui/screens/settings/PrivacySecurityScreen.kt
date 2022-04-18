package com.csci448.jaidynnfohr.alpha_release.ui.screens.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.csci448.jaidynnfohr.alpha_release.R

@Composable
fun PrivacySecurityScreen(
    onBack : () -> Unit
){
    val uriHandler = LocalUriHandler.current
    val policyAnnotated = buildAnnotatedString {
        append(stringResource(R.string.policy_title))
        addStyle(
            style = SpanStyle(
                textDecoration = TextDecoration.Underline
            ),
            start = 0,
            end = stringResource(id = R.string.policy_title).lastIndex
        )
        addStringAnnotation(
            tag="URI",
            annotation = "https://www.youtube.com/watch?v=a40r8AhnPm8",
            start = 0,
            end = stringResource(id = R.string.policy_title).lastIndex
        )
    }

    val termsAnnotated = buildAnnotatedString {
        append(stringResource(R.string.terms_conditions_title))
        addStyle(
            style = SpanStyle(
                textDecoration = TextDecoration.Underline
            ),
            start = 0,
            end = stringResource(id = R.string.terms_conditions_title).lastIndex
        )
        addStringAnnotation(
            tag="URI",
            annotation = "https://www.youtube.com/watch?v=4HCofUFZ7n0",
            start = 0,
            end = stringResource(id = R.string.terms_conditions_title).lastIndex
        )
    }

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
            text = stringResource(id = R.string.privacy_security_title),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(16.dp))
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween
        ){
            TextButton(onClick = { getUserInfo() }) {
                Text(
                    text = stringResource(id = R.string.request_data),
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.app_green_color)
                )
            }
            Spacer(Modifier.height(16.dp))
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(start = 8.dp, end = 8.dp)
            ) {
                ClickableText(
                    text = policyAnnotated,
                    onClick = { position ->
                        val annotations = policyAnnotated.getStringAnnotations(
                            "URI",
                            start = position,
                            end = position
                        )
                        annotations.firstOrNull()?.let {
                            uriHandler.openUri(it.item)
                        }
                    },
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.app_green_color)
                    ),
                )
            }
            Spacer(Modifier.height(16.dp))
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(start = 8.dp, end = 8.dp)
            ) {
                ClickableText(
                    text = termsAnnotated,
                    onClick = { position ->
                        val annotations = termsAnnotated.getStringAnnotations(
                            "URI",
                            start = position,
                            end = position
                        )
                        annotations.firstOrNull()?.let {
                            uriHandler.openUri(it.item)
                        }
                    },
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.app_green_color)
                    ),
                )
            }
            Spacer(Modifier.height(24.dp))
        }
    }
}

private fun getUserInfo(){

}

@Preview(showBackground = true)
@Composable
private fun PreviewPrivacySecurityScreen(){
    PrivacySecurityScreen {

    }
}