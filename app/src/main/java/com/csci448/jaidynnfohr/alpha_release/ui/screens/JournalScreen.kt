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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.sp


@Composable
fun JournalPage(
    mood_choice: String,
    color_selection: Color,
    onAddMood: () -> Unit
) {
    LazyColumn(
        Modifier
            .padding(18.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        item{
            Row(

            ) { // Anchor view
                Card(
                    Modifier
                        .padding(vertical = 8.dp)
                        .fillMaxWidth()
                        .height(84.dp)
                        .clickable(onClick = onAddMood),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = mood_choice,
                            color = color_selection,
                            fontSize = 36.sp
                        )
                    }
                }
            }
        }

        item{
            val journalEntryTitle: String = ""

            Row(
                Modifier.padding(top = 8.dp, bottom = 16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                val textState = remember { mutableStateOf(journalEntryTitle) }
                TextField(
                    modifier = Modifier.height(48.dp),
                    value = textState.value,
                    onValueChange = { textState.value = it },
                    placeholder = {
                        Text(stringResource(id = R.string.journal_entry_title_hint))
                    }
                )
            }
        }

        item{
            val journalEntry: String = ""

            Row(
                Modifier
                    .padding(bottom = 60.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                val textState = remember { mutableStateOf(journalEntry) }
                TextField(
                    modifier = Modifier.height(250.dp),
                    value = textState.value,
                    onValueChange = { textState.value = it },
                    placeholder = {
                        Text(stringResource(id = R.string.journal_entry_thoughts_hint))
                    }
                )
            }
        }


    }


}