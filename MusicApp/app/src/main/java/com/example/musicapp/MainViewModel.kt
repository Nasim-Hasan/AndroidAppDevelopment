package com.example.musicapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val _currentScreen:MutableState<Screen> = mutableStateOf(Screen.DrawerScreen.AddAccount)

    fun setCurrentScreen(screen:Screen){
        _currentScreen.value=screen
    }

    fun getCurrentScreen():MutableState<Screen>{
        return _currentScreen
    }
}