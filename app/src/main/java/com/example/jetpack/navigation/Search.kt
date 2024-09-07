package com.example.jetpack.navigation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import com.example.jetpack.ui.theme.Blue
import com.example.jetpack.ui.theme.SoftBlue

@Composable
fun Search(
    modifier: Modifier = Modifier,
    onQueryChange: (String) -> Unit
) {
    var text by remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .padding(20.dp)
            .shadow(2.dp, RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
            .border(BorderStroke(1.dp, color = Blue), RoundedCornerShape(8.dp))
            .padding(12.dp)
    ) {
        BasicTextField(
            value = text,
            onValueChange = {
                text = it
                onQueryChange(it)
            },
            textStyle = TextStyle(fontSize = 16.sp),
            modifier = Modifier.fillMaxWidth(),
            decorationBox = { innerTextField ->
                if (text.isEmpty()) {
                    Text(
                        text = "Search here",
                        style = TextStyle(color = SoftBlue, fontSize = 16.sp)
                    )
                }
                innerTextField()
            }
        )
    }
}
