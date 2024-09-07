package com.example.wbnewproject.phonenumber

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State

class PhoneNumberViewModel : ViewModel() {

    // Хранение выбранного кода страны
    private val _selectedCountryCode = mutableStateOf("+7")
    val selectedCountryCode: State<String> = _selectedCountryCode

    // Хранение введенного номера телефона
    private val _phoneNumber = mutableStateOf("")
    val phoneNumber: State<String> = _phoneNumber

    // Флаг для управления видимостью DropdownMenu
    private val _expanded = mutableStateOf(false)
    val expanded: State<Boolean> = _expanded

    fun onCountryCodeChange(newCode: String) {
        _selectedCountryCode.value = newCode
    }

    fun onPhoneNumberChange(newNumber: String) {
        _phoneNumber.value = newNumber
    }

    fun onExpandedChange(newExpanded: Boolean) {
        _expanded.value = newExpanded
    }
}
