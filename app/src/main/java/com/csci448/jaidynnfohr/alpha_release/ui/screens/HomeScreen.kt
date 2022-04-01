package com.csci448.jaidynnfohr.alpha_release.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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


@Composable
fun ScrollingCards(
    onNew: () -> Unit,
    onRecent: () -> Unit,
    onMetrics: () -> Unit,
    onJournal: () -> Unit
    ){
    Column(
        Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .height(84.dp)
                .clickable( onClick = onNew ),
            shape = RoundedCornerShape(20.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    imageVector = Icons.Filled.AddCircle,
                    contentDescription = "Add icon",
                    tint = colorResource(id = R.color.green),
                    modifier = Modifier
                        .weight(1f)
                        .height(64.dp)
                )
                Text(stringResource(id = R.string.new_entries_label_long),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(horizontal = 4.dp, vertical = 4.dp)
                        .weight(1f)
                )
            }
        }

        Card(
            Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .height(84.dp)
                .clickable( onClick = onRecent ),
            shape = RoundedCornerShape(20.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    imageVector = Icons.Filled.DateRange,
                    contentDescription = "Calendar icon",
                    tint = colorResource(id = R.color.green),
                    modifier = Modifier
                        .weight(1f)
                        .height(64.dp)
                )
                Text(stringResource(id = R.string.recent_additions_label_long),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(horizontal = 4.dp, vertical = 4.dp)
                        .weight(1f)
                )
            }
        }

        Card(
            Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .height(84.dp)
                .clickable( onClick = onMetrics ),
            shape = RoundedCornerShape(20.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    imageVector = Icons.Filled.MultilineChart,
                    contentDescription = "Chart icon",
                    tint = colorResource(id = R.color.green),
                    modifier = Modifier
                        .weight(1f)
                        .height(64.dp)
                )
                Text(stringResource(id = R.string.metrics_tracker_label_long),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(horizontal = 4.dp, vertical = 4.dp)
                        .weight(1f)
                )
            }
        }

        Card(
            Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .height(84.dp)
                .clickable( onClick = onJournal ),
            shape = RoundedCornerShape(20.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    imageVector = Icons.Filled.Book,
                    contentDescription = "Journal icon",
                    tint = colorResource(id = R.color.green),
                    modifier = Modifier
                        .weight(1f)
                        .height(64.dp)
                )
                Text(stringResource(id = R.string.journal_records_label_long),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(horizontal = 4.dp, vertical = 4.dp)
                        .weight(1f)
                )
            }
        }

        Card(
            Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .height(84.dp),
            shape = RoundedCornerShape(20.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search icon",
                    tint = colorResource(id = R.color.green),
                    modifier = Modifier
                        .weight(1f)
                        .height(64.dp)
                )
                Text(stringResource(id = R.string.support_resources_label_long),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(horizontal = 4.dp, vertical = 4.dp)
                        .weight(1f)
                )
            }
        }
    }
}


