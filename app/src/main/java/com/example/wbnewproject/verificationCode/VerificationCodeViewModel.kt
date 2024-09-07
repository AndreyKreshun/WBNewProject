package com.example.wbnewproject.verificationCode

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class VerificationCodeViewModel: ViewModel() {
   private val _code: MutableState<String> = mutableStateOf("")
    val code: State<String> = _code

    fun onCodeChange(newCode: String){
        if (newCode.length <= 4){
            _code.value = newCode
        }
    }

    fun resetCode(){
        _code.value = ""
    }
}