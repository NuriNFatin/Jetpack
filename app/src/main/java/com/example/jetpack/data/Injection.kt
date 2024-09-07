package com.example.jetpack.data

object Injection {
    fun provideRepository(): ProfileRepository {
        return ProfileRepository.getInstance()
    }
}