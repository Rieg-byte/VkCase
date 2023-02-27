package com.example.vkcase

import android.app.Activity
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.GridView
import androidx.compose.material.icons.outlined.Groups
import androidx.compose.material.icons.rounded.ChatBubbleOutline
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.vkcase.ui.theme.Grey900
import com.example.vkcase.ui.theme.GreyLight900
import com.example.vkcase.ui.theme.Red700


@Composable
fun CallScreen(
    onContactButton: () -> Unit = {},
    onChatButton: () -> Unit = {}) {
    var openReactionDialog by remember{ mutableStateOf(false) }
    var microphoneOn by remember{ mutableStateOf(false) }
    Column(
        Modifier
            .fillMaxSize()
            .background(Grey900)) {
        TopBar(
            Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .weight(1f),
            onContactButton = onContactButton,
            onChatButton = onChatButton
        )
        if (openReactionDialog) {
            ReactionDialog(
                Modifier
                    .width(400.dp),
                onDismissRequest = {openReactionDialog = false},
                onClickButton = {openReactionDialog = false}
            )
        }
        MemberGrid(
            Modifier
                .fillMaxWidth()
                .padding(6.dp)
                .weight(8f),
            microphoneOn = microphoneOn
        )
        BottomBar(
            Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .weight(2f),
            onClickReactionDialog = {openReactionDialog = true},
            openReactionDialog = openReactionDialog,
            onClickMicrophone = {microphoneOn = !microphoneOn},
            microphoneOn = microphoneOn
        )
    }
}


@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    onContactButton: () -> Unit = {},
    onChatButton: () -> Unit = {},
){
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = onChatButton
        ) {
            Icon(
                imageVector = Icons.Rounded.ChatBubbleOutline,
                contentDescription = stringResource(id = R.string.chat),
                tint = Color.White
            )
        }
        IconButton(
            onClick = onContactButton
        ) {
            Icon(
                imageVector = Icons.Outlined.Groups,
                contentDescription = stringResource(id = R.string.members),
                tint = Color.White
            )
        }
        IconButton(
            onClick = { /*TODO*/ }
        ) {
            Icon(
                imageVector = Icons.Outlined.GridView,
                contentDescription = stringResource(id = R.string.grid),
                tint = Color.White
            )
        }
    }
}


@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    onClickReactionDialog: () -> Unit = {},
    openReactionDialog: Boolean,
    onClickMicrophone: () -> Unit = {},
    microphoneOn: Boolean
){
    val activity = LocalContext.current as? Activity
    var videoCamOn by remember{ mutableStateOf(false) }
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { videoCamOn = !videoCamOn },
            modifier = Modifier
                .clip(RoundedCornerShape(50))
                .background(if (videoCamOn) GreyLight900 else Color.White)
        ) {
            Icon(
                imageVector =  if(videoCamOn) Icons.Filled.Videocam else Icons.Filled.VideocamOff,
                contentDescription = stringResource(id = R.string.videocam),
                tint = if(videoCamOn) Color.White else Color.Black
            )
        }
        IconButton(
            onClick = onClickMicrophone,
            modifier = Modifier
                .clip(RoundedCornerShape(50))
                .background(if (microphoneOn) GreyLight900 else Color.White)
        ) {
            Icon(
                imageVector = if(microphoneOn) Icons.Filled.Mic else Icons.Filled.MicOff,
                contentDescription = stringResource(id = R.string.microphone),
                tint = if(microphoneOn) Color.White else Color.Black
            )
        }
        IconButton(
            onClick = onClickReactionDialog,
            modifier = Modifier
                .clip(RoundedCornerShape(50))
                .background(if (!openReactionDialog) GreyLight900 else Color.White)
        ) {
            Icon(
                imageVector = Icons.Filled.FrontHand,
                contentDescription = stringResource(id = R.string.front_hand),
                tint = if(!openReactionDialog) Color.White else Color.Black
            )
        }
        IconButton(
            onClick = { activity?.finish() },
            modifier = Modifier
                .clip(RoundedCornerShape(50))
                .background(Red700)
        ) {
            Icon(
                imageVector = Icons.Filled.CallEnd,
                contentDescription = stringResource(id = R.string.call_end),
                tint = Color.White
            )
        }
    }
}


@Composable
fun MemberGrid(
    modifier: Modifier = Modifier,
    microphoneOn: Boolean,
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        MemberItem(
            Modifier.weight(1f),
            name = "Вы",
            R.drawable.user,
            microphoneOn = microphoneOn
        )
        Spacer(modifier = Modifier.height(6.dp))
        MemberItem(
            Modifier.weight(1f),
            name = "Очень длинный контакт Тест для тестирования",
            R.drawable.user1)
    }
}

@Composable
fun MemberItem(
    modifier: Modifier = Modifier,
    name: String,
    @DrawableRes profileIcon: Int,
    microphoneOn: Boolean = false
){
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(5),
    ) {
        Box(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(50)),
                painter = painterResource(id = profileIcon),
                contentDescription = null,
                contentScale = ContentScale.Crop)
            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 10.dp, start = 10.dp, end = 10.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    modifier = Modifier
                        .weight(1f, fill = false),
                    text = name,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.White
                )
                Icon(
                    imageVector = if(microphoneOn) Icons.Filled.Mic else Icons.Filled.MicOff,
                    contentDescription = null,
                    tint= Color.White
                )
            }
        }
    }
}

