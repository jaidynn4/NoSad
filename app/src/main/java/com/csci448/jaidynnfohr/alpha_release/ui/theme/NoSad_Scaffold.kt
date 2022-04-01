package com.csci448.jaidynnfohr.alpha_release.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.csci448.jaidynnfohr.alpha_release.R

@Composable
fun NoSad_Scaffold(content: @Composable () -> Unit,
                   onAddItem: () -> Unit,
                   onRecent: () -> Unit,
                   onMetrics: () -> Unit,
                   onJournal: () -> Unit,
                   onSupport: () -> Unit,
                   onHome: () -> Unit,
                   onSettings: () -> Unit
                   ){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("NoSad") },
                backgroundColor = colorResource(id = R.color.green),
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = "Home icon",
                        modifier = Modifier.clickable(onClick = onHome)
                    )
                },
                actions = {
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = "Settings icon",
                        modifier = Modifier.clickable(onClick = onSettings)
                    )
                }
            )
        },
        content = {
            content()
        },
        bottomBar = {
            BottomAppBar(
                backgroundColor = colorResource(id = R.color.green)
            ) {
                BottomNavigation(
                    backgroundColor = colorResource(id = R.color.green)
                ) {
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.AddCircle,
                                contentDescription = "Add icon"
                            )
                        },
                        label = {
                            Text(stringResource(id = R.string.new_entries_label_1))
                        },
                        selected = false,
                        selectedContentColor = colorResource(id = R.color.light_green),
                        unselectedContentColor = colorResource(id = R.color.black),
                        onClick = onAddItem
                    )
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.DateRange,
                                contentDescription = "Calendar icon"
                            )
                        },
                        label = {
                            Text(stringResource(id = R.string.recent_additions_label_1))
                        },
                        selected = false,
                        selectedContentColor = colorResource(id = R.color.green),
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
                            Text(stringResource(id = R.string.weekly_metrics_label_2))
                        },
                        selected = false,
                        selectedContentColor = colorResource(id = R.color.green),
                        unselectedContentColor = colorResource(id = R.color.black),
                        onClick = onMetrics
                    )
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.Book,
                                contentDescription = "Journal icon"
                            )
                        },
                        label = {
                            Text(stringResource(id = R.string.your_journal_label_2))
                        },
                        selected = false,
                        selectedContentColor = colorResource(id = R.color.green),
                        unselectedContentColor = colorResource(id = R.color.black),
                        onClick = onJournal
                    )
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = "Resources icon"
                            )
                        },
                        label = {
                            Text(stringResource(id = R.string.support_resources_label_1))
                        },
                        selected = false,
                        selectedContentColor = colorResource(id = R.color.green),
                        unselectedContentColor = colorResource(id = R.color.black),
                        onClick = onSupport
                    )
                }
            }
        }
    )
}
