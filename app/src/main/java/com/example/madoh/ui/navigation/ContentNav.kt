package com.example.madoh.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.madoh.Expense
import com.example.madoh.ExpensePage
import com.example.madoh.Welcome
import com.example.madoh.ui.navigation.Routes.NAV_ACC
import com.example.madoh.ui.navigation.Routes.NAV_HOME
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
            startDestination = NAV_HOME,
            ) {
            composable(NAV_HOME){
                Welcome(navController)
            }
            composable(NAV_STATS){

            }
            composable(NAV_ACC){}
            composable(NAV_TRANSACTION){
                ExpensePage(navController)
            }
        }

    }
}