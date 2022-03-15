package com.csci448.jaidynnfohr.alpha_release.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.csci448.jaidynnfohr.alpha_release.R
import com.csci448.jaidynnfohr.alpha_release.ui.theme.NoSad_Scaffold

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun DayWeekMonth() {
    val dotTotal = 3
    val pagerState = rememberPagerState(initialPage = 2)
    HorizontalPager(count = dotTotal, state = pagerState) { page ->

        when(page) {
            0 -> MonthView()
            1 -> WeekView()
            2 -> DayView()
        }

    }
}

@Composable
private fun MonthView() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row() {
            Text(text = stringResource(id = R.string.month_view_label), fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.padding(2.dp))
            Icon(painter = painterResource(id = R.drawable.ic_baseline_arrow_left_24), contentDescription = "left_arrow")
            Spacer(modifier = Modifier.padding(2.dp))
            Text(text = stringResource(id = R.string.week_view_label))
            Icon(painter = painterResource(id = R.drawable.ic_baseline_arrow_left_24), contentDescription = "left_arrow")
            Spacer(modifier = Modifier.padding(2.dp))
            Text(text = stringResource(id = R.string.day_view_label))
        }
        
    }
}

@Composable
private fun WeekView() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row() {
            Text(text = stringResource(id = R.string.month_view_label))
            Spacer(modifier = Modifier.padding(2.dp))
            Icon(painter = painterResource(id = R.drawable.ic_baseline_arrow_left_24), contentDescription = "left_arrow")
            Spacer(modifier = Modifier.padding(2.dp))
            Text(text = stringResource(id = R.string.week_view_label), fontWeight = FontWeight.Bold)
            Icon(painter = painterResource(id = R.drawable.ic_baseline_arrow_left_24), contentDescription = "left_arrow")
            Spacer(modifier = Modifier.padding(2.dp))
            Text(text = stringResource(id = R.string.day_view_label))
        }
    }
}

@Composable
private fun DayView() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row() {
            Text(text = stringResource(id = R.string.month_view_label))
            Spacer(modifier = Modifier.padding(2.dp))
            Icon(painter = painterResource(id = R.drawable.ic_baseline_arrow_left_24), contentDescription = "left_arrow")
            Spacer(modifier = Modifier.padding(2.dp))
            Text(text = stringResource(id = R.string.week_view_label))
            Icon(painter = painterResource(id = R.drawable.ic_baseline_arrow_left_24), contentDescription = "left_arrow")
            Spacer(modifier = Modifier.padding(2.dp))
            Text(text = stringResource(id = R.string.day_view_label), fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = stringResource(id = R.string.mood_label))
        val horizontalGradientBrush = Brush.horizontalGradient(
            colors = listOf(
                Color.Red,
                Color.Yellow,
                Color.Red
            )
        )
        Card(elevation = 8.dp, shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .size(320.dp, 50.dp)) {
            Text(text = stringResource(id = R.string.sample_mood_descriptor), textAlign = TextAlign.Center)

        }
        Spacer(modifier = Modifier.padding(8.dp))
        Card(elevation = 8.dp, shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .size(320.dp, 50.dp)) {
            Box(
                Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(horizontalGradientBrush)
                    .size(320.dp, 50.dp)
            ) {
            }
        }

        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = stringResource(id = R.string.mood_over_time_label))
        Card(elevation = 8.dp, shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .size(320.dp, 100.dp)) {
            Text(text = stringResource(id = R.string.sample_graph_text), textAlign = TextAlign.Center)
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MetricsScreenPreview() {
    NoSad_Scaffold { DayWeekMonth() }
}