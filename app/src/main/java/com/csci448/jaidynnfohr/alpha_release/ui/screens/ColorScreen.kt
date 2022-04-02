package com.csci448.jaidynnfohr.alpha_release.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.csci448.jaidynnfohr.alpha_release.R
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp


@Composable
fun EmotionsDropDown(){
    val emotionsList = mutableListOf<String>()
    stringArrayResource(R.array.emotions_list).forEach {
        item -> emotionsList.add(item)
    }

    val loveList = mutableListOf<String>()
    stringArrayResource(R.array.love_list).forEach {
            item -> loveList.add(item)
    }

    val joyList = mutableListOf<String>()
    stringArrayResource(R.array.joy_list).forEach {
            item -> joyList.add(item)
    }

    val surpriseList = mutableListOf<String>()
    stringArrayResource(R.array.surprise_list).forEach {
            item -> surpriseList.add(item)
    }

    val sadnessList = mutableListOf<String>()
    stringArrayResource(R.array.sadness_list).forEach {
            item -> sadnessList.add(item)
    }

    val angerList = mutableListOf<String>()
    stringArrayResource(R.array.anger_list).forEach {
            item -> angerList.add(item)
    }

    val fearList = mutableListOf<String>()
    stringArrayResource(R.array.fear_list).forEach {
            item -> fearList.add(item)
    }

    val list_of_lists = mutableListOf<MutableList<String>>()
    list_of_lists.add(loveList)
    list_of_lists.add(joyList)
    list_of_lists.add(surpriseList)
    list_of_lists.add(sadnessList)
    list_of_lists.add(angerList)
    list_of_lists.add(fearList)

    val loveSublist = mutableListOf<String>()
    stringArrayResource(R.array.love_sublist).forEach {
            item -> loveSublist.add(item)
    }

    val joySublist = mutableListOf<String>()
    stringArrayResource(R.array.joy_sublist).forEach {
            item -> joySublist.add(item)
    }

    val surpriseSublist = mutableListOf<String>()
    stringArrayResource(R.array.surprise_sublist).forEach {
            item -> surpriseSublist.add(item)
    }

    val sadnessSublist = mutableListOf<String>()
    stringArrayResource(R.array.sadness_sublist).forEach {
            item -> sadnessSublist.add(item)
    }

    val angerSublist = mutableListOf<String>()
    stringArrayResource(R.array.anger_sublist).forEach {
            item -> angerSublist.add(item)
    }

    val fearSublist = mutableListOf<String>()
    stringArrayResource(R.array.fear_sublist).forEach {
            item -> fearSublist.add(item)
    }

    val list_of_sublists = mutableListOf<MutableList<String>>()
    list_of_sublists.add(loveSublist)
    list_of_sublists.add(joySublist)
    list_of_sublists.add(surpriseSublist)
    list_of_sublists.add(sadnessSublist)
    list_of_sublists.add(angerSublist)
    list_of_sublists.add(fearSublist)


    val colorList = mutableListOf<Color>()
    colorList.add(colorResource(R.color.love_red_color))
    colorList.add(colorResource(R.color.joy_yellow_color))
    colorList.add(colorResource(R.color.surprise_green_color))
    colorList.add(colorResource(R.color.sadness_blue_color))
    colorList.add(colorResource(R.color.anger_orange_color))
    colorList.add(colorResource(R.color.fear_purple_color))

    var emotion: String by remember { mutableStateOf(emotionsList[0]) }
    var emotion_expanded by remember { mutableStateOf(false)}

    var secondList: MutableList<String> by remember { mutableStateOf(list_of_lists[0])}
    var second_choice:String by remember { mutableStateOf(secondList[0])}
    var second_expanded by remember { mutableStateOf(false)}
    var second_visible by remember { mutableStateOf(false)}
    var subListIndex: Int by remember {mutableStateOf(0)}

    var thirdList: MutableList<String> by remember { mutableStateOf(list_of_sublists[0])}
    var third_choice: String by remember { mutableStateOf(thirdList[0])}
    var third_expanded by remember { mutableStateOf(false)}
    var third_visible by remember { mutableStateOf(false)}

    var answer_chosen by remember { mutableStateOf(false)}
    var color_selection by remember { mutableStateOf(colorList[0])}

    Box(Modifier.fillMaxWidth(),contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Row(
                Modifier
                    .padding(24.dp)
                    .clickable {
                        emotion_expanded = !emotion_expanded
                        third_visible = false
                        second_visible = false
                        answer_chosen = false
                    }
                    .padding(8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) { // Anchor view
                Text(text = emotion,fontSize = 18.sp,modifier = Modifier.padding(end = 8.dp)) // emotion name label
                Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "")

                //
                DropdownMenu(expanded = emotion_expanded, onDismissRequest = {
                    emotion_expanded = false
                }) {
                    for (i in 0 until emotionsList.size) {
                        DropdownMenuItem(onClick = {
                            emotion_expanded = false
                            emotion = emotionsList[i]
                            secondList = list_of_lists[i]
                            second_choice = secondList[0]
                            second_visible = true
                            thirdList = list_of_sublists[i]
                            third_choice = thirdList[0]
                            color_selection = colorList[i]
                        }) {
                            Text(text = emotionsList[i])
                        }
                    }
                }
            }

            if(second_visible){
                Row(
                    Modifier
                        .padding(24.dp)
                        .clickable {
                            second_expanded = !second_expanded
                            third_visible = false
                            answer_chosen = false
                        }
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) { // Anchor view
                    Text(text = second_choice,fontSize = 18.sp,modifier = Modifier.padding(end = 8.dp)) // emotion name label
                    Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "")


                    DropdownMenu(expanded = second_expanded, onDismissRequest = {
                        second_expanded = false
                    }) {
                        for (i in 0 until secondList.size) {
                            DropdownMenuItem(onClick = {
                                second_expanded = false
                                second_choice = secondList[i]
                                third_visible = true
                                subListIndex = i * 2
                            }) {
                                Text(text = secondList[i])
                            }
                        }
                    }
                }


                if (third_visible){
                    Row(
                        Modifier
                            .padding(24.dp)
                            .clickable {
                                third_expanded = !third_expanded
                                answer_chosen = false
                            }
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) { // Anchor view
                        Text(text = third_choice,fontSize = 18.sp,modifier = Modifier.padding(end = 8.dp)) // emotion name label
                        Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "")


                        DropdownMenu(expanded = third_expanded, onDismissRequest = {
                            third_expanded = false
                        }) {
                            DropdownMenuItem(onClick = {
                                third_expanded = false
                                third_choice = thirdList[subListIndex]
                                answer_chosen = true
                            }) {
                                Text(text = thirdList[subListIndex])
                            }
                            DropdownMenuItem(onClick = {
                                third_expanded = false
                                third_choice = thirdList[subListIndex + 1]
                                answer_chosen = true
                            }) {
                                Text(text = thirdList[subListIndex + 1])
                            }
                        }
                    }
                }
            }


            Row(
                Modifier
                    .padding(24.dp)
                    .padding(8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) { // Anchor view
                if (answer_chosen){
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
                        ) {
                            Text(
                                text = third_choice,
                                color = color_selection,
                                fontSize = 36.sp,
                                modifier = Modifier.padding(end = 8.dp),
                            )
                        }
                    }
                }
            }

            Row(
                Modifier
                    .padding(24.dp)
                    .clickable {
                        second_expanded = !second_expanded
                        third_visible = false
                        answer_chosen = false
                    }
                    .padding(8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = {}, shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(id = R.color.app_green_color),
                        contentColor = Color.White)) {
                    Text(text = stringResource(R.string.login_button_label), fontSize = 14.sp)
                }
            }
        }
    }
}