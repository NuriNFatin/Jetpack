package com.example.jetpack.data

import com.example.jetpack.model.Profile
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ProfileRepository private constructor() {
    private val users = mutableListOf<Profile>()

    init {
        if (users.isEmpty()) {
            FakeData.profiles.forEach {
                users.add(it)
            }
        }
    }

    fun getProfiles(): Flow<List<Profile>> = flowOf(users)

    fun getProfileById(userId: Long): Profile = users.first { it.id == userId }

    fun searchProfiles(query: String): List<Profile> = users.filter {
        it.login.contains(query, ignoreCase = true)
    }

    companion object {
        @Volatile
        private var instance: ProfileRepository? = null

        fun getInstance(): ProfileRepository =
            instance ?: synchronized(this) {
                ProfileRepository().apply {
                    instance = this
                }
            }
    }
}