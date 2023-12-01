package com.example.madoh

import android.app.DatePickerDialog
import androidx.compose.runtime.Composable
import android.os.Bundle
import android.widget.DatePicker
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Calendar
import java.util.Date


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Expense() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .background(Color.Blue)
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
                                color = Color.Blue,
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
                            .clickable { }
                            .weight(1f) // Take up equal width
                            .height(55.dp) // Adjust the size of the individual boxes
                            .background(Color.Blue)
                            .border(
                                width = 2.dp,
                                color = Color.White,
                                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                            )
                    ) {
                        Text(
                            text = "Box 1",
                            color = Color.White,
                            modifier = Modifier
                                .padding(8.dp)
                        )
                    }

                    Box(
                        modifier = Modifier
                            .clickable { }
                            .weight(1f) // Take up equal width
                            .height(55.dp) // Adjust the size of the individual boxes
                            .background(Color.Blue)
                            .border(
                                width = 2.dp,
                                color = Color.White,
                                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                            )
                    ) {
                        Text(
                            text = "Box 2",
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

        val amountText = remember { mutableStateOf("Amount") }
        val feesText = remember { mutableStateOf("Fees") }
        val categoryText = remember { mutableStateOf("Category") }
        val accountText = remember { mutableStateOf("Account") }
        val noteText = remember { mutableStateOf("Note") }
        val descriptionText = remember { mutableStateOf("Description") }

        for (pair in listOf(
            "Amount" to amountText,
            "Fees" to feesText,
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
                )
                TextField(
                    value = pair.second.value,
                    onValueChange = { newText -> pair.second.value = newText },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .weight(1f)
                        .height(65.dp)
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(8.dp),
                )
            }
        }
        for (pair in listOf(
            "Category" to categoryText,
            "Account" to accountText,
            "Note" to noteText,
            "Description" to descriptionText
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
                )
                TextField(
                    value = pair.second.value,
                    onValueChange = { newText -> pair.second.value = newText },
                    modifier = Modifier
                        .weight(1f)
                        .height(65.dp)
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(8.dp),
                )
            }
        }

        Spacer(modifier = Modifier.size(40.dp))

        Row(modifier = Modifier
            .padding(horizontal = 50.dp)){
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.width(100.dp),
                colors = ButtonDefaults.buttonColors(containerColor =  Color(0xFFFFA500))
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

    Row(

    ) {

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
