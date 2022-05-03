package com.csci448.jaidynnfohr.alpha_release.ui.screens

import android.provider.MediaStore
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.csci448.jaidynnfohr.alpha_release.R
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.colorResource
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import java.time.LocalTime

@Composable
fun JournalPage(
    mood_choice: String,
    color_selection: Color,
    title_text: String,
    thoughts_text: String,
    onAddMood: (String, String) -> Unit,
    onSaveJournalEntry: (Color, String, String, LocalDate, LocalTime, LocalTime, String, MediaStore.Audio?) -> Unit
) {

    val mood_set: Boolean by remember { mutableStateOf(color_selection != Color.White) }
    var journalTitle: String = title_text
    var title_set: Boolean by remember { mutableStateOf(journalTitle != "") }
    var journalThoughts: String = thoughts_text
    var entry_set: Boolean by remember { mutableStateOf(journalThoughts != "")}

    LazyColumn(
        Modifier
            .padding(18.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        item{
            Row(){ // Anchor view
                Card(
                    Modifier
                        .padding(vertical = 8.dp)
                        .fillMaxWidth()
                        .height(84.dp)
                        .clickable(
                            onClick = {
                                onAddMood(journalTitle, journalThoughts)
                            }
                        ),
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


            Row(
                Modifier.padding(top = 8.dp, bottom = 8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                val textState = remember { mutableStateOf(journalTitle) }
                TextField(
                    modifier = Modifier.height(56.dp),
                    value = textState.value,
                    onValueChange = {
                        textState.value = it
                        title_set = (it != "")
                        journalTitle = it
                    },
                    placeholder = {
                        Text(stringResource(id = R.string.journal_entry_title_hint))
                    }
                )
            }
        }

        item{
            Row(
                Modifier
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                val textState = remember { mutableStateOf(journalThoughts) }
                TextField(
                    modifier = Modifier.height(200.dp),
                    value = textState.value,
                    onValueChange = {
                        textState.value = it
                        entry_set = (it != "")
                        journalThoughts = it
                    },
                    placeholder = {
                        Text(stringResource(id = R.string.journal_entry_thoughts_hint))
                    }
                )
            }
        }

        item{
            Row(
                Modifier
                    .padding(bottom = 64.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        onSaveJournalEntry(color_selection, mood_choice, journalTitle, LocalDate.now(), LocalTime.now(), LocalTime.now(), journalThoughts, null)
                    },
                    enabled = (mood_set && title_set && entry_set),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(id = R.color.app_green_color),
                        contentColor = Color.White
                    )
                ) {
                    Text(text = stringResource(R.string.save_mood_button_label), fontSize = 14.sp)
                }
            }
        }
    }


}