package com.csci448.jaidynnfohr.alpha_release.ui

import androidx.compose.animation.core.animateIntSizeAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.csci448.jaidynnfohr.alpha_release.R

//dots modified from medium.com

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun TutorialSlides() {

    val pagerState = rememberPagerState(initialPage = 0)
    val dotTotal = 3

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            HorizontalPager(count = dotTotal, state = pagerState) { page ->

                Column {
                    Card(
                        elevation = 8.dp, shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .size(320.dp, 200.dp)
                    ) {
                        Image(
                            painter = painterResource(
                                when (page) {
                                    0 -> R.drawable.top_bar
                                    1 -> R.drawable.bottom_bar
                                    2 -> R.drawable.resources
                                    else -> throw IllegalStateException("image not provided for page $page")
                                }
                            ), contentDescription = null

                        )
                    }
                    Spacer(modifier = Modifier.padding(4.dp))
                    Card(
                        elevation = 8.dp, shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .size(320.dp, 100.dp)
                    ) {
                        Text(
                            modifier = Modifier.padding(8.dp),
                            textAlign = TextAlign.Center,
                            text = when (page) {
                                0 -> stringResource(R.string.top_bar_hint)
                                1 -> stringResource(R.string.bottom_bar_hint)
                                2 -> stringResource(R.string.resources_hint)
                                else -> stringResource(R.string.default_mood_description)
                            },
                            fontSize = 14.sp
                        )
                    }
                }

            }

            Spacer(modifier = Modifier.padding(8.dp))
            Dots(dotTotal, pagerState.currentPage)
        }

}



@Composable
private fun Dots(dotTotal: Int, idx: Int) {
    LazyRow {
        items(dotTotal) { index ->
            when (index) {
                idx -> {
                    Box(
                        modifier = Modifier
                            .size(5.dp)
                            .clip(CircleShape)
                            .background(colorResource(id = R.color.app_green_color))
                    )
                }
                else -> {
                    Box(
                        modifier = Modifier
                            .size(4.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                    )
                }
            }
            if(index != dotTotal - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }
        }
    }
}

@Composable
private fun TitleAndDescription() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = stringResource(id = R.string.welcome_title),
            fontSize = 20.sp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Card(elevation = 8.dp, shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .size(320.dp, 100.dp)
                .padding(vertical = 8.dp)
        ) {
            Text(modifier = Modifier.padding(8.dp), text = stringResource(id = R.string.sample_description_text), fontSize = 14.sp)
        }
    }
}

@Composable
fun NewUserScreen(onUnderstood: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            TitleAndDescription()
        }
        Box(
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            TutorialSlides()
        }
        Box() {
            Button(
                onClick = onUnderstood,
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.app_green_color),
                    contentColor = Color.White
                )
            ) {
                Text(text = stringResource(R.string.understood_button), fontSize = 14.sp)
            }
        }
        Spacer(modifier = Modifier.padding(vertical = 16.dp))
    }
}