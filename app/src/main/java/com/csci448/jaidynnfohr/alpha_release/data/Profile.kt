package com.csci448.jaidynnfohr.alpha_release.data

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.csci448.jaidynnfohr.alpha_release.R
import java.util.*

class Profile(id: UUID=UUID.randomUUID(),
              language: String?,
              email: String?,
              name: String?,
              phone: String?,
              emergencyContact : String?)
{
    private val profileID = id
    private var chosenLanguage = language
    private var profileEmail = email
    private var profileName = name
    private var profilePhone = phone
    private var profileEmergContact = emergencyContact

    fun setLanguage(newLanguage : String){
        chosenLanguage = newLanguage
    }
    fun setEmail(newEmail : String){
        profileEmail = newEmail
    }
    fun setName(newName : String){
        profileName = newName
    }
    fun setPhone(newPhone : String){
        profilePhone = newPhone
    }
    fun setEmergContact(newContact : String){
        profileEmergContact = newContact
    }

    fun getID() : UUID{
        return profileID
    }

    fun getLanguage() : String? {
        return chosenLanguage
    }
    fun getName() : String?{
        return profileName
    }
    fun getEmail() : String?{
        return profileEmail
    }
    fun getPhone() : String?{
        return profilePhone
    }
    fun getEmergContact() : String?{
        return profileEmergContact
    }
}