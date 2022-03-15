package com.csci448.jaidynnfohr.alpha_release.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.csci448.jaidynnfohr.alpha_release.R
import com.csci448.jaidynnfohr.alpha_release.ui.theme.NoSad_Scaffold

//dots modified from medium.com

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun TutorialSlides() {

    val pagerState = rememberPagerState(initialPage = 0)
    val dotTotal = 3
    Box() {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            HorizontalPager(count = dotTotal, state = pagerState) { page ->
                Image(
                    painter = painterResource(
                        when (page) {
                            0 -> R.drawable.barry_b__benson
                            1 -> R.drawable.barry_b__benson
                            2 -> R.drawable.barry_b__benson
                            else -> throw IllegalStateException("image not provided for page $page")
                        }
                    ), contentDescription = null,
                    modifier = Modifier.shadow(
                        elevation = 8.dp,
                        shape = RoundedCornerShape(16.dp),
                        clip = true
                    )

                )
            }
            Spacer(modifier = Modifier.padding(4.dp))
            Dots(dotTotal, pagerState.currentPage)
        }
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
                            .background(Color.Black)
                    )
                }
                else -> {
                    Box(
                        modifier = Modifier
                            .size(4.dp)
                            .clip(CircleShape)
                            .background(Color.DarkGray)
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
        Text(text = stringResource(id = R.string.welcome_title), fontSize = 20.sp)
        Spacer(modifier = Modifier.padding(horizontal = 8.dp))
        Card(elevation = 8.dp,
            shape = RoundedCornerShape(20.dp)
            ) {
            Text(modifier = Modifier.padding(8.dp), text = stringResource(id = R.string.sample_description_text), fontSize = 14.sp)
        }
    }
}

@Composable
private fun NewUserScreen() {
    Column(Modifier.fillMaxSize()) {
        Box(Modifier.weight(1f)) {
            TitleAndDescription()
        }
        Spacer(modifier = Modifier.padding(horizontal = 16.dp))
        Box(Modifier.weight(2f)) {
            TutorialSlides()
        }
    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun NewUserScreenPreview() {
    NoSad_Scaffold { NewUserScreen() }
}