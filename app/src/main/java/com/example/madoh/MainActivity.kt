package com.example.madoh

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.madoh.ui.theme.MadohTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                    Content()
            }
        }
    }


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Welcome(navController: NavHostController?= null){
    Scaffold( topBar = { WelcomeCard(name = "Franklin") }
        , floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController?.navigate("addTransaction")
                },
                content = {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Add Expense or Income"
                    )
                }
            )
        }
    )
    {
        Transactions(it)
    }
}

@Preview
@Composable
fun PreviewWelcome () {
    Welcome()
}

@Composable
fun WelcomeCard(name: String) {
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current.density

    val deviceWidth = (configuration.screenWidthDp * density).toInt()
    val ss = 170
Box (modifier = Modifier
    .fillMaxWidth()
    .height(ss.dp)
    .background(color = Color.Blue)){
            Row (
                modifier = Modifier
                    .absolutePadding(
                        top = (ss / 4).dp,
                        left = (deviceWidth / 20).dp
                    )
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = Color.White)
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.frank_photo),
                    contentDescription = "User Profile Picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                )
                Text(text = "Welcome, $name!", modifier = Modifier.padding(10.dp),
                    style = MaterialTheme.typography.labelLarge.copy(fontSize = 30.sp),
                )
            }
        }
}

data class TransactionDay(val date: Date, val transactions: List<Transaction>)

data class Transaction(val amount: Double,
                       val category: String,
                       val account: String,
                        val note: String)
val days = mutableListOf<TransactionDay>(
    FillerData.transactionsSample[0],
    FillerData.transactionsSample[1],
    FillerData.transactionsSample[2],
    FillerData.transactionsSample[3],
    FillerData.transactionsSample[4],
    FillerData.transactionsSample[5],
    FillerData.transactionsSample[6],
)
@Composable
fun Transactions(it: PaddingValues){
Box (modifier = Modifier.padding(it)){
    LazyColumn {
        item {
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                        append("Transactions")
                    }
                },
                style = MaterialTheme.typography.headlineSmall,
            )
        }
        items(days) { day ->
            TransactionCard(day)
        }
    }
}
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WelcomeCard("Franklin")
}

@Preview(showBackground = true)
@Composable
fun TransactionsPreview() {
//    Transactions()
}

@Composable
fun TransactionCard(transactionDay: TransactionDay) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Display Date
            Text(
                text = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault()).format(transactionDay.date),
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            // Display Transactions
            TransactionList(transactionDay.transactions)
        }
    }
}

@Composable
fun TransactionList(transactions: List<Transaction>) {
    Column {
        transactions.forEach { transaction ->
            TransactionItem(transaction)
        }
    }
}

@Composable
fun TransactionItem(transaction: Transaction) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Display Category
        Text(
            text = transaction.category,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary
        )

        // Display Note and Account
        Column(
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(start = 8.dp)
        ) {
            Text(
                text = transaction.note,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = transaction.account,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface
            )
        }

        // Display Amount
        Text(
            text = "Ksh${transaction.amount}",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTransactionCard() {
    MadohTheme {
        val sampleData = FillerData.transactionsSample.firstOrNull()
        sampleData?.let { TransactionCard(it) }
    }
}
