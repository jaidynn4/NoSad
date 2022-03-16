package com.csci448.jaidynnfohr.alpha_release.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NoSadViewModelFactory() : ViewModelProvider.Factory {
    fun getViewModelClass() = NoSadViewModel::class.java

    override fun <T : ViewModel?> create(modelClass: Class<T>) : T {
        if( modelClass.isAssignableFrom(getViewModelClass()) )
            return modelClass.getConstructor()
                .newInstance()
        throw IllegalArgumentException("Unknown Viewmodel")
    }
}