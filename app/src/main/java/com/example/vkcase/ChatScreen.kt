package com.example.vkcase

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.example.vkcase.ui.theme.Grey900

@Composable
fun ChatScreen(onBackButton: () -> Unit = {}){
    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Grey900) {
                IconButton(onClick = onBackButton) {
                    Icon(
                        imageVector = Icons.Filled.ChevronLeft,
                        contentDescription = stringResource(id = R.string.back),
                        tint = Color.White
                    )
                }
                Text(
                    text = stringResource(id = R.string.chat),
                    fontSize = 22.sp,
                    color = Color.White
                )
            }
        }
    ){
        padding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(padding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = stringResource(id = R.string.chat), color = Color.White, fontSize = 22.sp)
        }
    }
}