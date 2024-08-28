package com.example.wbnewproject

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList

class InterestingViewModel : ViewModel() {

    // Список для хранения выбранных тегов
    private val _selectedTags = mutableStateListOf<String>()
    val selectedTags: SnapshotStateList<String> = _selectedTags

    // Функция для обработки нажатия на чип
    fun onChipClick(tag: String) {
        if (_selectedTags.contains(tag)) {
            _selectedTags.remove(tag)
        } else {
            _selectedTags.add(tag)
        }
    }
}
