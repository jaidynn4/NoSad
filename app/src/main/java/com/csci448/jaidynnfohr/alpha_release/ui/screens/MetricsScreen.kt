package com.csci448.jaidynnfohr.alpha_release.ui

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.csci448.jaidynnfohr.alpha_release.R

@OptIn(ExperimentalPagerApi::class)
@Composable
fun DayWeekMonth(metricsColorList: MutableList<Color>, metricsMoodList: MutableList<String>) {


    val dotTotal = 3
    val pagerState = rememberPagerState(initialPage = 2)
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        DWM(pagerState.currentPage)
        Spacer(modifier = Modifier.padding(4.dp))
        HorizontalPager(count = dotTotal, state = pagerState) { page ->

            when(page) {
                0 -> MonthView(metricsColorList, metricsMoodList)
                2 -> DayView(metricsColorList, metricsMoodList)
                1 -> WeekView(metricsColorList, metricsMoodList)
            }

        }
    }

}

@Composable
private fun MonthView(metricsColorList: MutableList<Color>, metricsMoodList: MutableList<String>) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Spacer(modifier = Modifier.padding(8.dp))
        val brush = shimmer(colorList = metricsColorList)
        Text(text = stringResource(id = R.string.mood_over_month_label))

        Spacer(modifier = Modifier.padding(4.dp))
        Card(elevation = 8.dp, shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .size(320.dp, 50.dp)) {
            Box(
                Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(brush)
                    .size(320.dp, 50.dp)
            ) {
            }
        }

        val mostFrequentColor = getMostFrequentColor(metricsColorList)

        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = stringResource(id = R.string.mood_month_label))
        Spacer(modifier = Modifier.padding(4.dp))
        if(mostFrequentColor != null) {
            Card(
                elevation = 8.dp, shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .size(320.dp, 100.dp)
            ) {
                Text(
                    text = stringResource(id = convertMoodToDescriptor(mostFrequentColor)),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
private fun WeekView(metricsColorList: MutableList<Color>, metricsMoodList: MutableList<String>) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = stringResource(id = R.string.mood_week_label))
        val brush = shimmer(colorList = metricsColorList.takeLast(7))
        Spacer(modifier = Modifier.padding(4.dp))
        Card(elevation = 8.dp, shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .size(320.dp, 50.dp)) {
            Box(
                Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(brush)
                    .size(320.dp, 50.dp)
            ) {
            }
        }

        val mostFrequentColor = getMostFrequentColor(metricsColorList.takeLast(7))

        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = stringResource(id = R.string.mood_month_label))
        Spacer(modifier = Modifier.padding(4.dp))
        if(mostFrequentColor != null) {
            Card(
                elevation = 8.dp, shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .size(320.dp, 100.dp)
            ) {
                Text(
                    text = stringResource(id = convertMoodToDescriptor(mostFrequentColor)),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

fun getMostFrequentColor(metricsColorList: List<Color>): Color? {
    val filteredColorList = metricsColorList.filter { it != Color.DarkGray }
    
    val colorCount = filteredColorList.groupingBy { it }.eachCount()
    return colorCount.maxByOrNull { it.value }?.key
}

@Composable
private fun DayView(metricsColorList: MutableList<Color>, metricsMoodList: MutableList<String>) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = stringResource(id = R.string.mood_label))
        val brush = shimmer(colorList = listOf(metricsColorList.last(),metricsColorList.last(), metricsColorList.last(), Color.DarkGray ))

        Spacer(modifier = Modifier.padding(4.dp))
        Card(elevation = 8.dp, shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .size(320.dp, 50.dp)) {
            Box(
                Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(brush)
                    .size(320.dp, 50.dp)
            ) {
            }
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = stringResource(id = R.string.mood_over_time_label))
        Spacer(modifier = Modifier.padding(4.dp))
        Card(elevation = 8.dp, shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .size(320.dp, 100.dp)) {
            Text(text = stringResource(id = convertMoodToDescriptor(metricsColorList.last())), textAlign = TextAlign.Center)
        }
    }
}

@Composable
private fun DWM(idx: Int) {
    val words = listOf("Month", "Week", "Today")
    LazyRow() {
        items(3) { index ->
            when (index) {
                idx -> {
                    Row() {
                        Text(text = words[idx], fontWeight = FontWeight.Bold)
                    }
                }
                else -> {
                    Text(text = words[index])
                }

            }
            Row(horizontalArrangement = Arrangement.Center) {
                if (index != 3 - 1) {
                    Row {
                        Spacer(modifier = Modifier.padding(2.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_arrow_left_24),
                            contentDescription = "left_arrow"
                        )
                        Spacer(modifier = Modifier.padding(2.dp))
                    }
                }
            }
        }
    }

}

@Composable
fun convertMoodToDescriptor(mood: Color): Int {
    return when(mood) {
        colorResource(R.color.love_red_color) -> R.string.love_description
        colorResource(R.color.joy_yellow_color)-> R.string.joy_description
        colorResource(R.color.sadness_blue_color) -> R.string.sadness_description
        colorResource(R.color.fear_purple_color) -> R.string.fear_description
        colorResource(R.color.anger_orange_color) -> R.string.anger_description
        colorResource(R.color.surprise_green_color) -> R.string.surprise_description
        else -> R.string.default_mood_description
    }
}

@Composable
fun shimmer(colorList: List<Color>): Brush {
    val transition = rememberInfiniteTransition()
    val translateAnim by transition.animateFloat(
        initialValue = 0f,
        targetValue = 500f,
        animationSpec = infiniteRepeatable(

            tween(durationMillis = 5000, easing = FastOutSlowInEasing),
            RepeatMode.Restart
        )
    )
    val brush = Brush.linearGradient(
        colors = colorList.reversed(),
        end = Offset(0f,0f),//Offset(10f, 10f),
        start = Offset(translateAnim, translateAnim)
    )

    return brush
}
