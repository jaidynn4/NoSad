package com.csci448.jaidynnfohr.alpha_release.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.csci448.jaidynnfohr.alpha_release.data.database.JournalEntryRepository

class NoSadViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    fun getViewModelClass() = NoSadViewModel::class.java

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass
            .getConstructor(JournalEntryRepository::class.java, Context::class.java)
            .newInstance(JournalEntryRepository.getInstance(context), context)
    }
}