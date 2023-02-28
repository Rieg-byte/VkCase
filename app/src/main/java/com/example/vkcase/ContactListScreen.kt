package com.example.vkcase

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkcase.data.Contact
import com.example.vkcase.data.listOfContact
import com.example.vkcase.ui.theme.Grey900


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ContactListScreen(onBackButton: () -> Unit = {}){
    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Grey900) {
                IconButton(onClick = onBackButton) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.back),
                        tint = Color.White
                    )
                }
                Text(
                    text = stringResource(id = R.string.contacts),
                    fontSize = 22.sp,
                    color = Color.White
                )
            }
        }
    ){
        padding ->
        LazyColumn(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxSize()
                .padding(padding)
        ) {
            items(listOfContact){
                ContactItem(contact = it)
            }
        }
    }
}

@Composable
fun ContactItem(contact: Contact, modifier: Modifier = Modifier){
    Card(
        modifier = modifier
            .padding(8.dp),
        backgroundColor = Grey900
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProfileIcon(profileIcon = contact.image)
            Text(
                text = contact.name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

        }
    }
}

@Composable
fun ProfileIcon(@DrawableRes profileIcon: Int, modifier: Modifier = Modifier){
    Image(
        modifier = modifier
            .size(64.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(50)),
        contentScale = ContentScale.Crop,
        painter = painterResource(profileIcon),
        contentDescription = null
    )
}