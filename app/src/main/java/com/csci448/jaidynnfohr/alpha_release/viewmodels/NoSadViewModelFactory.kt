package com.csci448.jaidynnfohr.alpha_release.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.csci448.jaidynnfohr.alpha_release.data.database.NoSadRepository

class NoSadViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    fun getViewModelClass() = NoSadViewModel::class.java
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(getViewModelClass()))
            return modelClass
                .getConstructor(NoSadRepository::class.java, Context::class.java)
                .newInstance(NoSadRepository.getInstance(context), context)
        throw IllegalArgumentException("Unknown ViewModel")
    }
}