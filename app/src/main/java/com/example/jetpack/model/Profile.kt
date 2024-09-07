package com.example.jetpack.model

data class Profile(
    val id: Long,
    val login: String,
    val bio: String,
    val favGame: String,
    val avatarUrl: Int,
    val playGameCount: Int,
    val follower: Int,
    val following: Int,
)