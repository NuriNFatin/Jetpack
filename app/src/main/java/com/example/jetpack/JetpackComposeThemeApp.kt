package com.example.jetpack

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpack.navigation.BottomNav
import com.example.jetpack.ui.account.AccountScreen
import com.example.jetpack.ui.home.HomeScreen
import com.example.jetpack.ui.detail.DetailScreen
import com.example.jetpack.navigation.Screen  // Pastikan Screen diimport dari paket yang benar
import com.example.jetpack.ui.theme.JetpackComposeTheme

@Composable
fun JetpackComposeThemeApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentState = navBackStackEntry?.destination?.route
    Scaffold(
        bottomBar = {
            if (currentState != Screen.DetailProfile.route) {
                BottomNav(navController)
            }
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    navigateToDetail = { userId ->
                        navController.navigate(Screen.DetailProfile.createRoute(userId))
                    }
                )
            }
            composable(Screen.Profile.route) {
                AccountScreen()
            }
            composable(
                route = Screen.DetailProfile.route,
                arguments = listOf(navArgument("userId") { type = NavType.LongType }),
            ) {
                val id = it.arguments?.getLong("userId") ?: -1L
                DetailScreen(
                    userId = id,
                    navigateBack = {
                        navController.navigateUp()
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun JetpackComposeThemeAppPreview() {
    JetpackComposeTheme { JetpackComposeThemeApp() }
}