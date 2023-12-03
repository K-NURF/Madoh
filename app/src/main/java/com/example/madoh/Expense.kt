package com.example.madoh

import android.app.DatePickerDialog
import androidx.compose.runtime.Composable
import android.widget.DatePicker
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.madoh.ui.navigation.BottomNav
import com.example.madoh.ui.navigation.Routes.NAV_EXPENSE
import com.example.madoh.ui.navigation.Routes.NAV_INCOME
import java.util.Calendar
import java.util.Date


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpensePage(navController: NavHostController){
    Scaffold(
        bottomBar = { BottomNav(navController = navController) }
    ) {
        Expense(it, navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Expense(it: PaddingValues, navController: NavHostController = rememberNavController()) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .background(Color(0xFF0247FE))
                .fillMaxWidth()
//                .padding(horizontal = 8.dp)
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
                            .background(Color(R.color.blue_100))
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


        Row {
            showDatePicker()
        }

        val amountText = remember { mutableStateOf("") }
        val categoryText = remember { mutableStateOf("") }
        val accountText = remember { mutableStateOf("") }
        val noteText = remember { mutableStateOf("") }

        for (pair in listOf(
            "Amount" to amountText,
        )) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(
                    text = pair.first,
                    modifier = Modifier
                        .width(100.dp)
                        .alignByBaseline()
                        .padding(end = 4.dp)
                )
                OutlinedTextField(
                    value = pair.second.value,
                    label = {Text(pair.first)},
                    onValueChange = { newText -> pair.second.value = newText },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .weight(1f)
                        .height(85.dp)
                        .fillMaxWidth()
                        .alignByBaseline()
                        .background(Color.White)
                        .padding(8.dp),

                    )
            }
        }
        for (pair in listOf(
            "Category" to categoryText,
            "Account" to accountText,
            "Note" to noteText,
        )) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(
                    text = pair.first,
                    modifier = Modifier
                        .width(100.dp)
                        .padding(end = 4.dp)
                        .alignByBaseline()
                )
                OutlinedTextField(
                    value = pair.second.value,
                    onValueChange = { newText -> pair.second.value = newText },
                    label = {Text(pair.first)},
                    modifier = Modifier
                        .weight(1f)
                        .height(85.dp)
                        .fillMaxWidth()
                        .alignByBaseline()
                        .background(Color.White)
                        .padding(8.dp)
                )
            }
        }

        Spacer(modifier = Modifier.size(40.dp))

        Row(modifier = Modifier
            .padding(horizontal = 50.dp)){
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.width(100.dp),
                colors = ButtonDefaults.buttonColors(containerColor =  Color(0xFFEA4335))
            ) {
                Text(text = "Save")
            }

            Spacer(modifier = Modifier.size(40.dp))

            Button(onClick = { /*TODO*/ },
                modifier = Modifier.width(150.dp),
                colors = ButtonDefaults.buttonColors(containerColor =  Color.Black)) {
                Text(text = "Continue")
            }
        }
    }
}

@Composable
fun showDatePicker(){

    val context = LocalContext.current
    val year: Int
    val month: Int
    val day: Int

    val calendar = Calendar.getInstance()
    year = calendar.get(Calendar.YEAR)
    month = calendar.get(Calendar.MONTH)
    day = calendar.get(Calendar.DAY_OF_MONTH)
    calendar.time = Date()

    val date = remember { mutableStateOf("") }
    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            date.value = "$dayOfMonth/$month/$year"
        }, year, month, day
    )

    Row() {

        Text(text = "Date",
            style = TextStyle(
                fontSize = 16.sp,

                ))
        Spacer(modifier = Modifier.size(72.dp))

        Text(text = buildAnnotatedString {
            withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                append("            ${date.value}                           ")
            }
        },
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.White)
                .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
                .padding(8.dp)
                .height(30.dp)
                .clickable {
                    datePickerDialog.show()
                },
            style = TextStyle(
                fontSize = 16.sp,

                ))

        Spacer(modifier = Modifier.size(16.dp))

    }

}
@Preview
@Composable
fun ViewExpenses(){
    Surface {
       Expense(PaddingValues(start=0.0.dp, top=0.0.dp, end=0.0.dp, bottom=56.0.dp))
    }
}
