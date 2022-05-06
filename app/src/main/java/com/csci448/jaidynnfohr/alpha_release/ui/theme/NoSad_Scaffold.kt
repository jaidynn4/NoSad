package com.csci448.jaidynnfohr.alpha_release.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.csci448.jaidynnfohr.alpha_release.R

@Composable
fun NoSad_Scaffold(content: @Composable () -> Unit,
                   onHome: () -> Unit,
                   onSettings: () -> Unit,
                   onAddMood: () -> Unit,
                   onJournal: () -> Unit,
                   onRecent: () -> Unit,
                   onMetrics: () -> Unit,
                   onSupport: () -> Unit,
                   bottomBarItemNumber: Int /*1-5 for nav icon enabling, 0 for other screens*/
                   ){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("NoSad") },
                backgroundColor = colorResource(id = R.color.app_green_color),
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = "Home icon",
                        modifier = Modifier
                            .clickable(onClick = onHome)
                            .padding(all = 8.dp)
                    )
                },
                actions = {
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = "Settings icon",
                        modifier = Modifier
                            .clickable(onClick = onSettings)
                            .padding(all = 8.dp)
                    )
                },
            )
        },
        content = {
            content()
        },
        bottomBar = {
            BottomAppBar(
                backgroundColor = colorResource(id = R.color.app_green_color)
            ) {
                BottomNavigation(
                    backgroundColor = colorResource(id = R.color.app_green_color)
                ) {
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.AddCircle,
                                contentDescription = "Add icon"
                            )
                        },
                        label = {
                            Text(stringResource(id = R.string.add_mood_label_short))
                        },
                        selected = (bottomBarItemNumber == 1),
                        selectedContentColor = colorResource(id = R.color.white),
                        unselectedContentColor = colorResource(id = R.color.black),
                        onClick = onAddMood
                    )
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.Book,
                                contentDescription = "Journal icon"
                            )
                        },
                        label = {
                            Text(stringResource(id = R.string.journal_entry_label_short))
                        },
                        selected = (bottomBarItemNumber == 2),
                        selectedContentColor = colorResource(id = R.color.white),
                        unselectedContentColor = colorResource(id = R.color.black),
                        onClick = onJournal
                    )
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.DateRange,
                                contentDescription = "Calendar icon"
                            )
                        },
                        label = {
                            Text(stringResource(id = R.string.record_history_label_short))
                        },
                        selected = (bottomBarItemNumber == 3),
                        selectedContentColor = colorResource(id = R.color.white),
                        unselectedContentColor = colorResource(id = R.color.black),
                        onClick = onRecent
                    )
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.MultilineChart,
                                contentDescription = "Chart icon"
                            )
                        },
                        label = {
                            Text(stringResource(id = R.string.metrics_tracker_label_short))
                        },
                        selected = (bottomBarItemNumber == 4),
                        selectedContentColor = colorResource(id = R.color.white),
                        unselectedContentColor = colorResource(id = R.color.black),
                        onClick = onMetrics
                    )
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.Search,//TODO handshake icon
                                contentDescription = "Resources icon"
                            )
                        },
                        label = {
                            Text(stringResource(id = R.string.support_resources_label_short))
                        },
                        selected = (bottomBarItemNumber == 5),
                        selectedContentColor = colorResource(id = R.color.white),
                        unselectedContentColor = colorResource(id = R.color.black),
                        onClick = onSupport
                    )
                }
            }
        }
    )
}
