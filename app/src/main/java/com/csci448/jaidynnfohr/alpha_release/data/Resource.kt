package com.csci448.jaidynnfohr.alpha_release.data

import java.util.*

class Resource(id:UUID=UUID.randomUUID(),title:String,blurb:String) {
    private val resourceID = id
    private var resourceTitle = title
    private var resourceBlurb = blurb

    fun getID() : UUID{
        return resourceID
    }
    fun getTitle() : String{
        return resourceTitle
    }
    fun getResourceBlurb() : String{
        return resourceBlurb
    }
    fun setTitle(newTitle:String){
        resourceTitle = newTitle
    }
    fun setBlurb(newBlurb:String){
        resourceBlurb = newBlurb
    }
}