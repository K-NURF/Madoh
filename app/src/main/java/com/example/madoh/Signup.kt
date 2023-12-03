package com.example.madoh

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.madoh.ui.navigation.Routes.NAV_HOME

@Composable
fun SignUpPage(navController: NavHostController){
    Scaffold() {
        LoginScreen(it, navController)
    }
}

@Composable
fun LoginScreen(it: PaddingValues, navController: NavHostController = rememberNavController()) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background (Color(0xFF0247FE))
    ) {

        Image(
            painter = painterResource(id = R.drawable.madoh),
            contentDescription = "Madoh Logo",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
        )

        // Two-thirds white background section
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .fillMaxHeight(0.4f) // Fill 2/3 of the screen height
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)) // Rounded corners at the top
                .background(Color.White)
                .padding(start = 34.dp,
                    top = 40.dp,
                    end = 30.dp,
                    bottom = 45.dp,),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SocialMediaButton("Sign Up with Facebook", Color(0xFF1877F2), imageResource = R.drawable.facebook, navController)
            Spacer(modifier = Modifier.height(8.dp))
            SocialMediaButton("Sign Up with Google", Color.Gray, imageResource = R.drawable.google, navController)
            Spacer(modifier = Modifier.height(8.dp))
            SocialMediaButton("Sign Up with Twitter", Color.Black, imageResource = R.drawable.twitter, navController)
            Spacer(modifier = Modifier.height(24.dp))
            TextButton(onClick = { /* TODO: Implement Login Navigation */ }) {
                Text("Already Have an account? Log In", color = Color.Blue)
            }
        }
    }
}

@Composable
fun SocialMediaButton(text: String, backgroundColor: Color, imageResource: Int, navController: NavHostController) {
    Button(
        onClick = {
            navController.navigate(NAV_HOME)
                  },
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
        modifier = Modifier
            .fillMaxWidth()
            .padding (vertical = 2.dp)
            .height(45.dp),

        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Image
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = null, // You can provide a content description if needed
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.width(8.dp)) // Add spacing between image and text

            // Text
            Text(text, color = Color.White, fontWeight = FontWeight.Bold)
        }
    }
}

