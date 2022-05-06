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

//Note: this screen could have a future update to be an animated wheel with 2D Canvas Graphics
@Composable
fun EmotionsDropDown(
    onSaveMood: (Int, String) -> Unit
){
    //List of 1st-level emotion strings
    val emotionsList = mutableListOf<String>()
    stringArrayResource(R.array.emotions_list).forEach {
        item -> emotionsList.add(item)
    }

    //Lists of 2nd-level emotion strings
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

    //List of the 2nd-level lists
    val listOfLists = mutableListOf<MutableList<String>>()
    listOfLists.add(loveList)
    listOfLists.add(joyList)
    listOfLists.add(surpriseList)
    listOfLists.add(sadnessList)
    listOfLists.add(angerList)
    listOfLists.add(fearList)

    //Lists of the 3rd-level emotion strings
    //Note that each 2 entries correspond to one entry for the 2nd-level list of this emotion
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

    //List of all the 3rd-level emotion strings
    val listOfSublists = mutableListOf<MutableList<String>>()
    listOfSublists.add(loveSublist)
    listOfSublists.add(joySublist)
    listOfSublists.add(surpriseSublist)
    listOfSublists.add(sadnessSublist)
    listOfSublists.add(angerSublist)
    listOfSublists.add(fearSublist)

    //List of Int ids for the different color resources
    val colorIdList = mutableListOf<Int>()
    colorIdList.add(R.color.love_red_color)
    colorIdList.add(R.color.joy_yellow_color)
    colorIdList.add(R.color.surprise_green_color)
    colorIdList.add(R.color.sadness_blue_color)
    colorIdList.add(R.color.anger_orange_color)
    colorIdList.add(R.color.fear_purple_color)

    //Placeholder strings for each of the three dropdown menus
    val placeholderOne = stringResource(id = R.string.category_dropdown_placeholder)
    val placeholderTwo = stringResource(id = R.string.feeling_dropdown_placeholder)
    val placeholderThree = stringResource(id = R.string.specification_dropdown_placeholder)

    //VALUES of states for the first dropdown
    var firstMenuChoice: String by remember { mutableStateOf(placeholderOne) }
    var isFirstExpanded by remember { mutableStateOf(false)}

    //VALUES of states for the second dropdown
    var secondList: MutableList<String> by remember { mutableStateOf(listOfLists[0])}
    var secondMenuChoice:String by remember { mutableStateOf(placeholderTwo)}
    var isSecondExpanded by remember { mutableStateOf(false)}
    var isSecondVisible by remember { mutableStateOf(false)}
    var subListIndex: Int by remember {mutableStateOf(0)}

    //VALUES of states for the third dropdown
    var thirdList: MutableList<String> by remember { mutableStateOf(listOfSublists[0])}
    var thirdMenuChoice: String by remember { mutableStateOf(placeholderThree)}
    var isThirdExpanded by remember { mutableStateOf(false)}
    var isThirdVisible by remember { mutableStateOf(false)}

    //VALUE of state holding whether the save mood button should be displayed
    var isEmotionChosen by remember { mutableStateOf(false)}

    //VALUE of state holding the color id corresponding to the chosen emotion string
    //R.color.white if none is chosen
    var colorIdSelection by remember { mutableStateOf(R.color.white)}

    Box(Modifier.fillMaxWidth(),contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Row(
                Modifier
                    .clickable {
                        isFirstExpanded = !isFirstExpanded
                        isThirdVisible = false
                        isSecondVisible = false
                        isEmotionChosen = false
                        secondMenuChoice = placeholderTwo
                        colorIdSelection = R.color.white
                    }
                    .fillMaxWidth()
                    .padding(18.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 18.dp)
                ){
                    //Emotion name label
                    Text(
                        text = firstMenuChoice,
                        color = colorResource(colorIdSelection),
                        fontSize = 18.sp,
                        modifier = Modifier.padding(end = 8.dp))
                    Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "")

                    DropdownMenu(expanded = isFirstExpanded, onDismissRequest = {
                        isFirstExpanded = false
                    }) {
                        for (i in 0 until emotionsList.size) {
                            DropdownMenuItem(onClick = {
                                isFirstExpanded = false
                                firstMenuChoice = emotionsList[i]
                                secondList = listOfLists[i]
                                isSecondVisible = true
                                thirdList = listOfSublists[i]
                                colorIdSelection = colorIdList[i]
                            }) {
                                Text(
                                    text = emotionsList[i],
                                    color = colorResource(colorIdList[i]))
                            }
                        }
                    }
                }
            }

            if(isSecondVisible){
                Row(
                    Modifier
                        .clickable {
                            isSecondExpanded = !isSecondExpanded
                            isThirdVisible = false
                            isEmotionChosen = false
                            thirdMenuChoice = placeholderThree
                        }
                        .fillMaxWidth()
                        .padding(18.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 18.dp)
                    ) {

                        if (secondMenuChoice == placeholderTwo) {
                            Text(
                                text = secondMenuChoice,
                                fontSize = 18.sp,
                                modifier = Modifier.padding(end = 8.dp),
                                color = Color.White
                            ) // emotion name label
                        } else {
                            //Emotion Category label
                            Text(
                                text = secondMenuChoice,
                                fontSize = 18.sp,
                                modifier = Modifier.padding(end = 8.dp),
                                color = colorResource(colorIdSelection)
                            )
                        }

                        Icon(
                            imageVector = Icons.Filled.ArrowDropDown,
                            contentDescription = ""
                        )

                        DropdownMenu(expanded = isSecondExpanded, onDismissRequest = {
                            isSecondExpanded = false
                        }) {
                            for (i in 0 until secondList.size) {
                                DropdownMenuItem(onClick = {
                                    isSecondExpanded = false
                                    secondMenuChoice = secondList[i]
                                    isThirdVisible = true
                                    subListIndex = i * 2
                                }) {
                                    Text(
                                        text = secondList[i],
                                        color = colorResource(colorIdSelection)
                                    )
                                }
                            }
                        }
                    }
                }


                if (isThirdVisible){
                    Row(
                        Modifier
                            .clickable {
                                isThirdExpanded = !isThirdExpanded
                                isEmotionChosen = false
                            }
                            .fillMaxWidth()
                            .padding(18.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 18.dp)
                        ) {

                            if (thirdMenuChoice == stringResource(id = R.string.specification_dropdown_placeholder)) {
                                Text(
                                    text = thirdMenuChoice,
                                    fontSize = 18.sp,
                                    modifier = Modifier.padding(end = 8.dp), color = Color.White
                                )
                            } else {
                                Text(
                                    text = thirdMenuChoice,
                                    fontSize = 18.sp,
                                    modifier = Modifier.padding(end = 8.dp),
                                    color = colorResource(colorIdSelection)
                                )
                            }
                            Icon(
                                imageVector = Icons.Filled.ArrowDropDown,
                                contentDescription = ""
                            )


                            DropdownMenu(
                                expanded = isThirdExpanded,
                                onDismissRequest = {
                                    isThirdExpanded = false
                                }
                            ) {
                                DropdownMenuItem(
                                    onClick = {
                                        isThirdExpanded = false
                                        thirdMenuChoice = thirdList[subListIndex]
                                        isEmotionChosen = true
                                    }
                                ) {
                                    Text(
                                        text = thirdList[subListIndex],
                                        color = colorResource(colorIdSelection)
                                    )
                                }
                                DropdownMenuItem(
                                    onClick = {
                                        isThirdExpanded = false
                                        thirdMenuChoice = thirdList[subListIndex + 1]
                                        isEmotionChosen = true
                                    }
                                ) {
                                    Text(
                                        text = thirdList[subListIndex + 1],
                                        color = colorResource(colorIdSelection)
                                    )
                                }
                            }
                        }
                    }
                }
            }

            if(isEmotionChosen){
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
                                text = thirdMenuChoice,
                                color = colorResource(colorIdSelection),
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
                            onSaveMood(colorIdSelection, thirdMenuChoice)
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
    EmotionsDropDown { _, _ -> }
}