package com.example.jetpack.navigation

sealed class Screen (val route: String) {
    data object Home : Screen("home")
    data object Profile : Screen("profile")
    data object DetailProfile : Screen("home/{userId}") {
        fun createRoute(userId: Long) = "home/$userId"
    }
}