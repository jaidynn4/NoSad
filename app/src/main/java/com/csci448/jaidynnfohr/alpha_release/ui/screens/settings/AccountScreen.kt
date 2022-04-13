package com.csci448.jaidynnfohr.alpha_release.ui.screens.settings

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.csci448.jaidynnfohr.alpha_release.R
import com.csci448.jaidynnfohr.alpha_release.data.Profile
import com.csci448.jaidynnfohr.alpha_release.viewmodels.NoSadViewModel

@Composable
fun Account(
    viewModel : NoSadViewModel,
    myProfile: Profile,
    onBack : () -> Unit
){
    val nameState = remember{ mutableStateOf("")}
    val emailState = remember{ mutableStateOf("")}
    val phoneState = remember{ mutableStateOf("")}
    val emergState = remember{ mutableStateOf("")}
    val langState = remember{ mutableStateOf("")}
    val expanded = remember{ mutableStateOf(false)}
    val languages = stringArrayResource(id = R.array.languages).toList()
    val selectedIndex = remember{ mutableStateOf(0) }
    val context = LocalContext.current

    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Icon(
                imageVector = Icons.Rounded.KeyboardArrowLeft,
                contentDescription = stringResource(id = R.string.arrow_back_content_desc),
                modifier = Modifier
                    .clickable(onClick = onBack)
                    .size(40.dp),
            )
        }
        Text(
            text = stringResource(id = R.string.my_account_title),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ){
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Text("Name: ", fontSize = 20.sp)
                TextField(
                    value = nameState.value,
                    onValueChange = { nameState.value = it },
                    placeholder = { Text(text = myProfile.getName().toString())},
                    singleLine = true
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Text("Email: ", fontSize = 20.sp)
                TextField(
                    value = emailState.value,
                    onValueChange = { emailState.value = it },
                    placeholder = { Text(text = myProfile.getEmail().toString())},
                    singleLine = true
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Text("Phone: ", fontSize = 20.sp)
                TextField(
                    value = phoneState.value,
                    onValueChange = { phoneState.value = it },
                    placeholder = { Text(text = myProfile.getPhone().toString())},
                    singleLine = true
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Text("Emergency Contact: ", fontSize = 20.sp)
                TextField(
                    value = emergState.value,
                    onValueChange = { emergState.value = it },
                    placeholder = { Text(text = myProfile.getEmergContact().toString())},
                    singleLine = true
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.Start
            ){
                Text("Language: ", fontSize = 20.sp)
                Text(
                    text = languages[selectedIndex.value],
                    Modifier
                        .clickable(onClick = { expanded.value = true }),
                    fontSize = 20.sp
                )
                DropdownMenu(
                    expanded = expanded.value,
                    onDismissRequest = { expanded.value = false },

                    ) {
                    languages.forEachIndexed { index, title ->
                        DropdownMenuItem(
                            onClick = {
                                selectedIndex.value = index
                                expanded.value = false
                                langState.value = title
                            }) {
                            Text(text = title)
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick =
            {
                saveChanges(
                    profile = myProfile,
                    viewModel = viewModel,
                    name = nameState,
                    email = emailState,
                    phone = phoneState,
                    emergency = emergState,
                    language = langState
                )
                Toast.makeText(context,"Changes Saved!",Toast.LENGTH_SHORT).show()
            }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green, contentColor = Color.Black)
            ) {
                Text(text = stringResource(R.string.save_settings))
            }
        }
    }
}

fun saveChanges(
    profile: Profile,
    viewModel: NoSadViewModel,
    name : MutableState<String>,
    email : MutableState<String>,
    phone : MutableState<String>,
    emergency : MutableState<String>,
    language : MutableState<String>
){
    if(profile.getName() != name.value) profile.setName(name.value)
    if(profile.getEmail() != email.value) profile.setEmail(email.value)
    if(profile.getPhone() != phone.value) profile.setPhone(phone.value)
    if(profile.getEmergContact() != emergency.value) profile.setEmergContact(emergency.value)
    if(profile.getLanguage() != language.value) profile.setLanguage(language.value)
    // maybe do something with viewModel
}

//@Preview(showBackground = true)
//@Composable
//private fun PreviewAccount(){
//    Account(
//        NoSadViewModel(),
//        Profile(name = "Dwayne Johnson",
//            email = null,
//            phone = null,
//            emergencyContact = null,
//            language = null),
//        {})
//}
