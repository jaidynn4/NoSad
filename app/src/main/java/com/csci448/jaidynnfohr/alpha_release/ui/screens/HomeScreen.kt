package com.csci448.jaidynnfohr.alpha_release.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.csci448.jaidynnfohr.alpha_release.R
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.unit.sp


@Composable
fun ScrollingCards(
    onAddMood: () -> Unit,
    onRecent: () -> Unit,
    onMetrics: () -> Unit,
    onJournal: () -> Unit,
    onSupport: () -> Unit
    ){
    LazyColumn(
        Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Card(
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
                    .height(72.dp)
                    .clickable(onClick = onAddMood)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(16.dp)
                ){
                    Icon(
                        imageVector = Icons.Filled.AddCircle,
                        contentDescription = "Add icon",
                        tint = colorResource(id = R.color.app_green_color),
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp)
                    )
                    Text(stringResource(id = R.string.add_mood_label_long),
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .padding(horizontal = 4.dp, vertical = 4.dp)
                            .weight(1f)
                    )
                }
            }
        }

        item {
            Card(
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
                    .height(72.dp)
                    .clickable(onClick = onJournal)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(16.dp)
                ){
                    Icon(
                        imageVector = Icons.Filled.Book,
                        contentDescription = "Journal icon",
                        tint = colorResource(id = R.color.app_green_color),
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp)
                    )
                    Text(stringResource(id = R.string.journal_entry_label_long),
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .padding(horizontal = 4.dp, vertical = 4.dp)
                            .weight(1f)
                    )
                }
            }
        }

        item {
            Card(
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
                    .height(72.dp)
                    .clickable(onClick = onRecent)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(16.dp)
                ){
                    Icon(
                        imageVector = Icons.Filled.DateRange,
                        contentDescription = "Calendar icon",
                        tint = colorResource(id = R.color.app_green_color),
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp)
                    )
                    Text(stringResource(id = R.string.record_history_label_long),
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .padding(horizontal = 4.dp, vertical = 4.dp)
                            .weight(1f)
                    )
                }
            }
        }

        item {
            Card(
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
                    .height(72.dp)
                    .clickable(onClick = onMetrics)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(16.dp)
                ){
                    Icon(
                        imageVector = Icons.Filled.MultilineChart,
                        contentDescription = "Chart icon",
                        tint = colorResource(id = R.color.app_green_color),
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp)
                    )
                    Text(stringResource(id = R.string.metrics_tracker_label_long),
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .padding(horizontal = 4.dp, vertical = 4.dp)
                            .weight(1f)
                    )
                }
            }
        }

        item {
            Card(
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
                    .height(72.dp)
                    .clickable(onClick = onSupport)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(16.dp)
                ){
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search icon",
                        tint = colorResource(id = R.color.app_green_color),
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp)
                    )
                    Text(stringResource(id = R.string.support_resources_label_long),
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .padding(horizontal = 4.dp, vertical = 4.dp)
                            .weight(1f)
                    )
                }
            }
        }
    }
}

