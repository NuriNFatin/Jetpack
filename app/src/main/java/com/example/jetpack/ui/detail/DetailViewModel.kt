package com.example.jetpack.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpack.UiState
import com.example.jetpack.data.ProfileRepository
import com.example.jetpack.model.Profile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel (
    private val repository: ProfileRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<Profile>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<Profile>>
        get() = _uiState

    fun getProfileById(userId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getProfileById(userId))
        }
    }
}