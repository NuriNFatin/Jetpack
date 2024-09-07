package com.example.jetpack.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import com.example.jetpack.ui.theme.BlueHard
import com.example.jetpack.ui.theme.SoftBlue

@Composable
fun ProfileItem(
    image: Int,
    login: String,
    playGame: Int,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.padding(8.dp)) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier.size(48.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = login)
            Text(text = "Playing $playGame Game")
        }
    }
    Divider(
        color = SoftBlue,
        thickness = 1.dp,
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth()
    )
}
