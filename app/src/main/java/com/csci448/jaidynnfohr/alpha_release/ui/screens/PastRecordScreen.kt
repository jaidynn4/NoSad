package com.csci448.jaidynnfohr.alpha_release.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.csci448.jaidynnfohr.alpha_release.viewmodels.NoSadViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@Composable
    fun PastRecordScreen(list : List<JournalEntry>?, viewModel: NoSadViewModel){
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
                        val showDialog = MutableStateFlow(false)
                        RecordRow(entry = record, viewModel = viewModel, showDialog = showDialog)
                    }
                }
            }
        }
    }

    @Composable
    fun RecordRow(
        entry: JournalEntry,
        viewModel: NoSadViewModel,
        showDialog: MutableStateFlow<Boolean>
    ) {
        Card(modifier =
        Modifier
            .clickable { showDialog.value = true }
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
                    //Text(text = record.getDate())
                    Text(text = entry.journal_timestamp.date.toString())
                    Spacer(Modifier.width(8.dp))
                    //Text(text = record.getTextTime())
                    Text(text = entry.journal_timestamp.time.toString())
                    Column {

                    }
                }

                var title = ""
//                record.getTitle()?.let {
//                    title = it
//                }
                title = entry.journal_title
                Row(
                    Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    //var color = record.getColor()
                    var color = colorResource(id = entry.mood_color_id)
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
                
                RecordAlertDialog(
                    entry = entry,
                    showDialog = showDialog,
                    viewModel = viewModel
                )
            }
        }
    }


@Composable
fun RecordAlertDialog(
    entry: JournalEntry,
    showDialog: MutableStateFlow<Boolean>,
    viewModel: NoSadViewModel
) {
    val shouldShowDialog: StateFlow<Boolean> = showDialog.asStateFlow()
    val showDialogState: Boolean by shouldShowDialog.collectAsState()
    
    if(showDialogState){
        AlertDialog(
            onDismissRequest = {
                showDialog.value = false
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showDialog.value = false
                    }
                ){
                    Text(
                        text = stringResource(id = R.string.dialog_ok_button_label),
                        color = colorResource(id = R.color.app_green_color)
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showDialog.value = false
                        viewModel.deleteJournalEntry(entry)
                    }
                ){
                    Text(
                        text = stringResource(id = R.string.dialog_delete_button_label),
                        color = colorResource(id = R.color.app_green_color)
                    )
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
}


//    @Preview(showBackground = true)
//    @Composable
//    private fun PreviewRecordList(){
////        val instance = PastRecordViewModel.getInstance()
////        val state = instance.DataLiveList.observeAsState()
//        val list = mutableListOf<JournalEntry>()
//        for(i in 1..20){
//            //list.add(RecordGenerator.generateRandomRecord())
//        }
//        PastRecordScreen(list = list, viewmodel = /**no preview viewmodel made/)
//    }
//
