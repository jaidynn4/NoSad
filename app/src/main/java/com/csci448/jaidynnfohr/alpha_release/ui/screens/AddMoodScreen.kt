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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Composable
fun EmotionsDropDown(
    onSaveMood: (Color, String) -> Unit
){
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

    val placeholder_one = stringResource(id = R.string.category_dropdown_placeholder)
    val placeholder_two = stringResource(id = R.string.feeling_dropdown_placeholder)
    val placeholder_three = stringResource(id = R.string.specification_dropdown_placeholder)

    var emotion: String by remember { mutableStateOf(placeholder_one) }
    var emotion_expanded by remember { mutableStateOf(false)}

    var secondList: MutableList<String> by remember { mutableStateOf(list_of_lists[0])}
    var second_choice:String by remember { mutableStateOf(placeholder_two)}
    var second_expanded by remember { mutableStateOf(false)}
    var second_visible by remember { mutableStateOf(false)}
    var subListIndex: Int by remember {mutableStateOf(0)}

    var thirdList: MutableList<String> by remember { mutableStateOf(list_of_sublists[0])}
    var third_choice: String by remember { mutableStateOf(placeholder_three)}
    var third_expanded by remember { mutableStateOf(false)}
    var third_visible by remember { mutableStateOf(false)}

    var answer_chosen by remember { mutableStateOf(false)}
    var color_selection by remember { mutableStateOf(Color.White)}

    Box(Modifier.fillMaxWidth(),contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Row(
                Modifier
                    .padding(18.dp)
                    .clickable {
                        emotion_expanded = !emotion_expanded
                        third_visible = false
                        second_visible = false
                        answer_chosen = false
                        second_choice = placeholder_two
                        color_selection = Color.White
                    },
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) { // Anchor view
                Text(text = emotion, color = color_selection,fontSize = 18.sp,modifier = Modifier.padding(end = 8.dp)) // emotion name label
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
                            second_visible = true
                            thirdList = list_of_sublists[i]
                            color_selection = colorList[i]
                        }) {
                            Text(text = emotionsList[i], color = colorList[i])
                        }
                    }
                }
            }

            if(second_visible){
                Row(
                    Modifier
                        .padding(18.dp)
                        .clickable {
                            second_expanded = !second_expanded
                            third_visible = false
                            answer_chosen = false
                            third_choice = placeholder_three
                        },
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) { // Anchor view
                    if (second_choice == placeholder_two){
                        Text(text = second_choice,fontSize = 18.sp,modifier = Modifier.padding(end = 8.dp), color = Color.White) // emotion name label
                    } else {
                        Text(text = second_choice,fontSize = 18.sp,modifier = Modifier.padding(end = 8.dp), color = color_selection) // emotion name label
                    }

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
                                Text(text = secondList[i], color = color_selection)
                            }
                        }
                    }
                }


                if (third_visible){
                    Row(
                        Modifier
                            .padding(18.dp)
                            .clickable {
                                third_expanded = !third_expanded
                                answer_chosen = false
                            },
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (third_choice == stringResource(id = R.string.specification_dropdown_placeholder)){
                            Text(text = third_choice,fontSize = 18.sp,modifier = Modifier.padding(end = 8.dp), color = Color.White) // emotion name label
                        } else {
                            Text(text = third_choice,fontSize = 18.sp,modifier = Modifier.padding(end = 8.dp), color = color_selection) // emotion name label
                        }
                        Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "")


                        DropdownMenu(expanded = third_expanded, onDismissRequest = {
                            third_expanded = false
                        }) {
                            DropdownMenuItem(onClick = {
                                third_expanded = false
                                third_choice = thirdList[subListIndex]
                                answer_chosen = true
                            }) {
                                Text(text = thirdList[subListIndex], color = color_selection)
                            }
                            DropdownMenuItem(onClick = {
                                third_expanded = false
                                third_choice = thirdList[subListIndex + 1]
                                answer_chosen = true
                            }) {
                                Text(text = thirdList[subListIndex + 1], color = color_selection)
                            }
                        }
                    }
                }
            }

            if(answer_chosen){
                Row(
                    Modifier
                        .padding(18.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) { // Anchor view
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

                Row(
                    Modifier
                        .padding(18.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {
                            onSaveMood(color_selection, third_choice)
                        },
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = colorResource(id = R.color.app_green_color),
                            contentColor = Color.White)) {
                        Text(text = stringResource(R.string.make_journal_entry_button_label), fontSize = 14.sp)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ColorScreenPreview(){
    EmotionsDropDown({color, string -> {}})
}