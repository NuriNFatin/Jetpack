package com.example.jetpack.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jetpack.data.ProfileRepository
import com.example.jetpack.ui.detail.DetailViewModel
import com.example.jetpack.ui.home.HomeViewModel

class ViewModelFactory(private val repository: ProfileRepository) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            HomeViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            DetailViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
