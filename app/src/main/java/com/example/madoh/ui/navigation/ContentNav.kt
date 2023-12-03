package com.example.madoh.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.madoh.ExpensePage
import com.example.madoh.Graph
import com.example.madoh.GraphPage
import com.example.madoh.IncomePage
import com.example.madoh.SignUpPage
import com.example.madoh.Welcome
import com.example.madoh.ui.navigation.Routes.NAV_EXPENSE
import com.example.madoh.ui.navigation.Routes.NAV_HOME
import com.example.madoh.ui.navigation.Routes.NAV_INCOME
import com.example.madoh.ui.navigation.Routes.NAV_LOGIN
import com.example.madoh.ui.navigation.Routes.NAV_STATS
import com.example.madoh.ui.navigation.Routes.NAV_TRANSACTION

@Composable
fun Content () {
    val navController = rememberNavController()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        NavHost(navController = navController,
            startDestination = NAV_LOGIN,
            ) {
            composable(NAV_HOME){
                Welcome(navController)
            }
            composable(NAV_STATS){
                GraphPage(navController)
            }
            composable(NAV_LOGIN){
                SignUpPage(navController)
            }
            composable(NAV_TRANSACTION){
                ExpensePage(navController)
            }
            composable(NAV_EXPENSE){
                ExpensePage(navController)
            }
            composable(NAV_INCOME){
                IncomePage(navController)
            }
        }

    }
}