package com.example.vkcase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vkcase.ui.theme.VkCaseTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VkCaseTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "Call"
                    ) {
                        composable(route = "Call") {
                            CallScreen(
                                onContactButton = { navController.navigate("ContactList")},
                                onChatButton = {navController.navigate("Chat")}
                            )
                        }
                        composable(route = "ContactList") {
                            ContactListScreen(onBackButton = { navController.navigate("Call") })
                        }
                        composable(route = "Chat") {
                            ChatScreen(onBackButton = { navController.navigate("Call") })
                        }
                    }

                }
            }
        }
    }
}

