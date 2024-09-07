package com.example.jetpack.ui.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpack.UiState
import com.example.jetpack.navigation.ErrorScreen
import com.example.jetpack.data.Injection
import com.example.jetpack.model.Profile
import com.example.jetpack.ui.ViewModelFactory

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
    navigateToDetail: (Long) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    when (uiState) {
        is UiState.Loading -> {
            CircularProgressIndicator(modifier = Modifier.fillMaxSize())
        }
        is UiState.Success -> {
            val profileList = (uiState as UiState.Success<List<Profile>>).data
            HomeContent(
                profiles = profileList,
                navigateToDetail = navigateToDetail,
                onSearch = { query -> viewModel.searchUsers(query) }
            )
        }
        is UiState.Error -> {
            val errorMessage = (uiState as UiState.Error).errorMessage
            ErrorScreen(
                errorMessage = errorMessage,
                onRetry = { viewModel.getAllUsers() },
                modifier = modifier
            )
        }
    }
}

