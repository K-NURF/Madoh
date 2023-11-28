package com.example.madoh.ui.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import com.example.madoh.R
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNav(
    navController: NavController
){
    val navItems = listOf(NavItem.Home, NavItem.Stats, NavItem.Acc)

    BottomNavigation (backgroundColor = colorResource(id = R.color.blue_200)){
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        navItems.forEach{
            item -> BottomNavigationItem(
            selected = currentRoute == item.navRoute,
            onClick = {
                      navController.navigate(item.navRoute)
                      },
            selectedContentColor = Color.White,
            unselectedContentColor = Color.White.copy(0.4f),
            icon = { Icon(painter = painterResource(id = item.icon), contentDescription = "") },
            label = { Text(text = stringResource(id = item.title))}
        )
        }
    }

}