package com.csci448.jorji.resourcespast.ui.navigation.recordresourceSpecs

import androidx.navigation.NamedNavArgument

sealed interface IScreenSpec{
    val route: String
    val arguments: List<NamedNavArgument>

    fun navigateTo(vararg args: String?) : String
}