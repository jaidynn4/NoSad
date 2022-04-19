package com.csci448.jaidynnfohr.alpha_release.data

import java.util.*

class Profile(id: UUID=UUID.randomUUID(),
              language: String?,
              email: String?,
              name: String?,
              emergencyContact : String?,
              password: String?)
{
    private val profileID = id
    private var chosenLanguage = language
    private var profileEmail = email
    private var profileName = name
    private var profileEmergContact = emergencyContact
    private var profilePassword = password

    fun setLanguage(newLanguage : String){
        chosenLanguage = newLanguage
    }
    fun setEmail(newEmail : String){
        profileEmail = newEmail
    }
    fun setName(newName : String){
        profileName = newName
    }
    fun setEmergContact(newContact : String){
        profileEmergContact = newContact
    }
    fun setPassword(newPass : String){
        profilePassword = newPass
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
    fun getEmergContact() : String?{
        return profileEmergContact
    }
    fun getPassword() : String?{
        return profilePassword
    }
}