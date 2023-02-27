package com.example.vkcase

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.example.vkcase.ui.theme.Grey900

@Composable
fun ReactionDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    onClickButton: () -> Unit
){
    AlertDialog(
        modifier = modifier,
        onDismissRequest = onDismissRequest,
        title = { Text(stringResource(id = R.string.reactions)) },
        text = { Text("Привет!") },
        backgroundColor = Grey900,
        contentColor = Color.White,
        confirmButton = {
            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = Color.Black),
                onClick = onClickButton
            ) {
                Text(stringResource(id = R.string.ok), fontSize = 16.sp)
            }
        }
    )
}