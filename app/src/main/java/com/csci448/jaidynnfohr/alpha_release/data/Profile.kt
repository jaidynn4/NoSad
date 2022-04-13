package com.csci448.jaidynnfohr.alpha_release.data

import com.csci448.jaidynnfohr.alpha_release.R
import java.util.*

class Profile(id: UUID=UUID.randomUUID(),
              language: Int = R.string.language_eng,
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

    fun setLanguage(newLanguage : Int){
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

}