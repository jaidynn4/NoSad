package com.csci448.jaidynnfohr.alpha_release.viewmodels

import android.content.Context
import com.csci448.jaidynnfohr.alpha_release.data.database.JournalEntryRepository
import com.csci448.jaidynnfohr.alpha_release.data.database.ProfileInfoRepository

class NoSadViewModel(
    private val journalEntryRepository: JournalEntryRepository,
    //private val profileInfoRepository: ProfileInfoRepository,
    context: Context
) : INoSadViewModel() {

}