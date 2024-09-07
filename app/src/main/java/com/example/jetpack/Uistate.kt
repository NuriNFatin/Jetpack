package com.example.jetpack

sealed class UiState<out T> {
    data class Success<out T>(val data: T) : UiState<T>()
    data class Error(val errorMessage: String) : UiState<Nothing>()
    data object Loading : UiState<Nothing>()
}
