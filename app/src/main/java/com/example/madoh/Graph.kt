package com.example.madoh

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.madoh.ui.navigation.BottomNav
import com.example.madoh.ui.navigation.Routes.NAV_EXPENSE
import com.example.madoh.ui.navigation.Routes.NAV_INCOME

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GraphPage(navController: NavHostController){
    Scaffold(
        bottomBar = { BottomNav(navController = navController) }
    ) {
        Graph(it, navController)
    }
}
@Composable
fun Graph(it: PaddingValues, navController: NavHostController = rememberNavController()) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color(0xEEEDEDFF))
    ) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .background(Color(0xFF0247FE))
                .fillMaxWidth()
//                .padding(vertical = 8.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp) // Adjust padding as needed
                ) {
                    Text(
                        text = "< Sep 2023 >",
                        style = TextStyle(
                            fontSize = 24.sp,
                            color = Color.White
                        ),
                        modifier = Modifier.weight(1f) // Occupy the available space
                    )
                    Spacer(modifier = Modifier.size(16.dp))
                    Box(
                        modifier = Modifier
                            .width(70.dp)
                            .height(35.dp) // Adjust the size of the box as needed
                            .background(
                                color = Color(0xFF0247FE),
                                shape = RoundedCornerShape(16.dp) // Adjust the corner radius for rounded edges
                            )
                            .border(
                                width = 2.dp,
                                color = Color.White,
                                shape = RoundedCornerShape(16.dp)
                            )
                    ) {
                        Text(
                            text = "Monthly",
                            color = Color.White,
                            modifier = Modifier
                                .padding(8.dp)
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .clickable {
                                navController.navigate(NAV_EXPENSE)
                            }
                            .weight(1f) // Take up equal width
                            .height(55.dp) // Adjust the size of the individual boxes
                            .background(Color(0xFF0247FE))
                            .border(
                                width = 1.dp,
                                color = Color.White,
                            )
                            .padding(end = 8.dp)
                    ) {
                        Text(
                            text = "Expense",
                            color = Color.White,
                            modifier = Modifier
                                .padding(8.dp)
                        )
                    }

                    Box(
                        modifier = Modifier
                            .clickable {
                                navController.navigate(NAV_INCOME)
                            }
                            .weight(1f) // Take up equal width
                            .height(55.dp) // Adjust the size of the individual boxes
                            .background(Color(0xFF0247FE))
                            .border(
                                width = 1.dp,
                                color = Color.White,
                            )
                    ) {
                        Text(
                            text = "Income",
                            color = Color.White,
                            modifier = Modifier
                                .padding(8.dp)
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        Image (
            painter = painterResource(id = R.drawable.piechart),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)

        )
        Spacer(modifier = Modifier.height(40.dp))
        Image (
            painter = painterResource(id = R.drawable.food),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)

        )

    }
}

@Preview
@Composable
fun ViewGraph(){
    Graph(PaddingValues(start=0.0.dp, top=0.0.dp, end=0.0.dp, bottom=56.0.dp))
}