package com.compose.sample.ktorchat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.compose.sample.ktorchat.presentation.chat.ChatScreen
import com.compose.sample.ktorchat.presentation.username.UsernameScreen
import com.compose.sample.ktorchat.ui.theme.KtorchatTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KtorchatTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "username_screen") {
                        composable("username_screen") {
                            UsernameScreen(onNavigate = navController::navigate)
                        }
                        composable(
                            route = "chat_screen/{username}",
                            arguments = listOf(
                                navArgument(name = "username") {
                                    type = NavType.StringType
                                    nullable = true
                                }
                            )
                        ) {
                            val username = it.arguments?.getString("username")
                            ChatScreen(username = username)
                        }
                    }
                }
            }
        }
    }
}