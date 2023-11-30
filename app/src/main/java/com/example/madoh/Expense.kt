package com.example.madoh

import androidx.compose.runtime.Composable
import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Expense() {
    Column {
        Box(
            modifier = Modifier
                .height(100.dp)
                .background(Color.Blue)
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Row {
                Text(text = "< Sep 2023 >",
                    style = TextStyle(
                        fontSize = 32.sp,
                        color = Color.White
                    )

                )
            }
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
                        .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
                        .padding(8.dp),
                )
            }
        }
    }
}

