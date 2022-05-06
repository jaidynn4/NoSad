package com.csci448.jaidynnfohr.alpha_release.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.csci448.jaidynnfohr.alpha_release.R
import com.csci448.jaidynnfohr.alpha_release.data.JournalEntry
import com.csci448.jaidynnfohr.alpha_release.data.PastRecord

@Composable
    fun PastRecordScreen(list : List<JournalEntry>?, onSelectRecord:(PastRecord) -> Unit){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(id = R.string.record_history_label_long),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 16.dp)
            )
            Divider(
                thickness = 2.dp,
                color = colorResource(id = R.color.app_green_color)
            )
            Spacer(Modifier.height(24.dp))
            if (list != null) {
                LazyColumn(
                    modifier = Modifier.padding(bottom = 64.dp)
                ) {
                    items(list) { record ->
                        RecordRow(record = record, onSelectRecord = onSelectRecord)
                    }
                }
            }
        }
    }

    @Composable
    fun RecordRow(record: JournalEntry,onSelectRecord: (PastRecord) -> Unit){
        Card(modifier =
        Modifier
            .clickable { onSelectRecord }
            .padding(8.dp)
            .fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            elevation = 8.dp
        ){
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val day = record.journal_timestamp.date.toString()
                    val mon = record.journal_timestamp.month.toString()
                    val yr = (record.journal_timestamp.year - 100).toString()
                    val hr = record.journal_timestamp.hours.toString()
                    val min = record.journal_timestamp.minutes.toString()
                    val sec = record.journal_timestamp.seconds.toString()
                    //Text(text = record.getDate())
                    Text(text = "${mon}/${day}/${yr}")
                    Spacer(Modifier.width(8.dp))
                    //Text(text = record.getTextTime())
                    Text(text = "${hr}:${min}:${sec}")
                    Column {

                    }
                }

                var title = ""
//                record.getTitle()?.let {
//                    title = it
//                }
                title = record.journal_title
                Row(
                    Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    //var color = record.getColor()
                    var color = colorResource(id = record.mood_color_id)
                    Text(text = title, color = color)
                }

                //TODO this section is commented until a JournalEntry stores audio
//                record.getAudio()?.let {
//                    System.out.println("got audio")
//                    //TODO
//                }
//                Row(
//                    Modifier
//                        .padding(8.dp)
//                        .fillMaxWidth(),
//                    horizontalArrangement = Arrangement.SpaceEvenly,
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Text(text = stringResource(id = R.string.record_audio_display_text))
//                    Text(text = record.getAudioTime())
//                }

            }
        }
    }


@Composable
fun RecordAlertDialog(entry: JournalEntry) {
    AlertDialog(
        onDismissRequest = {
              //TODO click outside dialog or back button should close dialog
        },
        confirmButton = {
            TextButton(
                onClick = {
                    //TODO close dialog
                }
            ){
                Text(text = stringResource(id = R.string.dialog_ok_button_label))
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    //TODO close dialog and delete record
                }
            ){
                Text(text = stringResource(id = R.string.dialog_delete_button_label))
            }
        },
        title = {
            TextButton(
                onClick = {

                }
            ){
                Text(
                    text = entry.journal_title,
                    color = colorResource(id = entry.mood_color_id)
                )
            }
        },
        text = {
            Text(text = entry.journal_entry)
        }
    )
}


    @Preview(showBackground = true)
    @Composable
    private fun PreviewRecordList(){
//        val instance = PastRecordViewModel.getInstance()
//        val state = instance.DataLiveList.observeAsState()
        val list = mutableListOf<JournalEntry>()
        for(i in 1..20){
            //list.add(RecordGenerator.generateRandomRecord())
        }
        PastRecordScreen(list = list, onSelectRecord = {})
    }
