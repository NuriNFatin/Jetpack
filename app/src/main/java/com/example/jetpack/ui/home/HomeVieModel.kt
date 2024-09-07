package com.example.jetpack.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpack.UiState
import com.example.jetpack.data.ProfileRepository
import com.example.jetpack.model.Profile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: ProfileRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<Profile>>>(UiState.Loading)
    val uiState: StateFlow<UiState<List<Profile>>> get() = _uiState

    init {
        getAllUsers()
    }

    fun getAllUsers() {
        viewModelScope.launch {
            try {
                repository.getProfiles().collect { profiles ->
                    _uiState.value = UiState.Success(profiles)
                }
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.message ?: "Unknown error")
            }
        }
    }

    fun searchUsers(query: String) {
        viewModelScope.launch {
            try {
                val searchResults = repository.searchProfiles(query)
                _uiState.value = UiState.Success(searchResults)
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.message ?: "Unknown error")
            }
        }
    }
}