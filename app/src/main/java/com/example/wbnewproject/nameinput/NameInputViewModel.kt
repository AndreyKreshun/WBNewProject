package com.example.wbnewproject.nameinput

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf

class NameInputViewModel {

    private val _name: MutableState<String> = mutableStateOf("")
    val name: State<String> = _name

    fun onNameChange(newName: String){
        _name.value = newName
    }
}