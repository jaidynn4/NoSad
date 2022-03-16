package com.csci448.jorji.resourcespast.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import java.util.*

abstract class GenericViewModel : ViewModel(){
    abstract val DataLiveList : LiveData<List<Any>>
    abstract val IDLiveList : LiveData<Any?>

    abstract fun addData(data : Any)
    abstract fun loadData(id : UUID)

}