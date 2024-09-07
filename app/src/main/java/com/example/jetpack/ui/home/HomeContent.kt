package com.example.jetpack.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.example.jetpack.model.Profile
import com.example.jetpack.model.ProfileItem
import com.example.jetpack.navigation.Search

@Composable
fun HomeContent(
    profiles: List<Profile>,
    navigateToDetail: (Long) -> Unit,
    onSearch: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Search(
            modifier = Modifier.fillMaxWidth(),
            onQueryChange = { query ->
                onSearch(query)
            }
        )

        if (profiles.isEmpty()) {
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "No profiles found")
            }
        } else {
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                modifier = modifier
            ) {
                items(profiles) { data ->
                    ProfileItem(
                        image = data.avatarUrl,
                        login = data.login,
                        playGame = data.playGameCount,
                        modifier = Modifier.clickable {
                            navigateToDetail(data.id)
                        }
                    )
                }
            }
        }
    }
}
