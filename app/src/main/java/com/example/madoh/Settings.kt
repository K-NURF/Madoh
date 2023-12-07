package com.example.madoh

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.madoh.ui.navigation.BottomNav
import com.example.madoh.ui.theme.MadohTheme

// Entry point of the app
//class Settings : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            MadohTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    SettingBody()
//                }
//            }
//        }
//    }
//}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsPage(navController: NavHostController){
    Scaffold(
        bottomBar = { BottomNav(navController = navController) }
    ) {
        SettingBody(it, navController)
    }
}
// Main composable for the Settings screen
@Composable
fun SettingBody(it: PaddingValues, navController: NavHostController = rememberNavController()) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "Settings", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(20.dp))

        // First LazyVerticalGrid for the main settings
        LazyVerticalGrid(
            cells = GridCells.Fixed(3),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(3) { index ->
                when (index) {
                    0 -> SettingsRow(title = "Account", icon = Icons.Default.AccountCircle, action = {})
                    1 -> SettingsRow(title = "Home", icon = Icons.Default.Home, action = {})
                    2 -> SettingsRow(title = "Configuration", icon = Icons.Default.Settings, action = {})
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(text = "Help", fontSize = 18.sp)
        Spacer(modifier = Modifier.height(20.dp))

        // Second LazyVerticalGrid for the help-related settings
        LazyVerticalGrid(
            cells = GridCells.Fixed(3),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(6) { index ->
                when (index) {
                    0 -> SettingsRow(title = "Random Ad", icon = Icons.Default.ThumbUp, action = {})
                    1 -> SettingsRow(title = "Stats", icon = Icons.Default.ThumbUp, action = {})
                    2 -> SettingsRow(title = "Passcode", icon = Icons.Default.ThumbUp, action = {})
                    3 -> SettingsRow(title = "Backup", icon = Icons.Default.AccountCircle, action = {})
                    4 -> SettingsRow(title = "Recommend", icon = Icons.Default.ThumbUp, action = {})
                    5 -> SettingsRow(title = "Accounts", icon = Icons.Default.AccountCircle, action = {})
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))
    }
}

// Wrapper for LazyVerticalGrid to match the provided Jetpack Compose structure
@Composable
fun LazyVerticalGrid(
    cells: GridCells,
    modifier: Modifier,
    content: @Composable LazyGridScope.() -> Unit
) {
    LazyVerticalGrid(cells = cells, modifier = modifier, content = content)
}

// Composable for each row in the grid
@Composable
fun SettingsRow(title: String, icon: ImageVector, action: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Icon for the setting
        Icon(imageVector = icon, contentDescription = null, modifier = Modifier.size(24.dp))
        // Text for the setting title
        Text(text = title, fontSize = 16.sp)
        // Button for additional action (e.g., navigation)
        Button(onClick = action, modifier = Modifier.size(24.dp), colors = ButtonDefaults.buttonColors(
            //backgroundColor = Color.Transparent,
            contentColor = Color.Unspecified
        )) {
            Text(text = ">")
        }
    }
}

// Preview for the Settings screen
@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    MadohTheme {
        SettingBody(PaddingValues(start=0.0.dp, top=0.0.dp, end=0.0.dp, bottom=56.0.dp))
    }
}
