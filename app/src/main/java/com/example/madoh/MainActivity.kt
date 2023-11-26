package com.example.madoh

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material3.icons.Icons
import androidx.compose.material3.icons.filled.AccountBalanceWallet
import androidx.compose.material3.icons.filled.CreditCard
import androidx.compose.material3.icons.filled.Home
import androidx.compose.material3.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.featherandroidtasks.ui.theme.FeatherAndroidTasksTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FeatherAndroidTasksTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    MoneyManagerApp()
                }
            }
        }
    }
}

@Composable
fun MoneyManagerApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Display welcome message
        WelcomeMessage("Maria")

        // Display recent transactions
        RecentTransactions(transactions = generateDummyTransactions(5))

        // Fixed navigation bar
        BottomNavigation {
            NavigationItem(
                icon = Icons.Default.Home,
                label = "Home",
                selected = true
            )
            NavigationItem(
                icon = Icons.Default.CreditCard,
                label = "Transactions"
            )
            NavigationItem(
                icon = Icons.Default.AccountBalanceWallet,
                label = "Wallet"
            )
            NavigationItem(
                icon = Icons.Default.Settings,
                label = "Settings"
            )
        }
    }
}

@Composable
fun WelcomeMessage(name: String) {
    Text(
        text = "Welcome $name",
        style = MaterialTheme.typography.h5,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

@Composable
fun RecentTransactions(transactions: List<Transaction>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
    ) {
        items(transactions) { transaction ->
            TransactionItem(transaction = transaction)
        }
    }
}

@Composable
fun TransactionItem(transaction: Transaction) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Icon(
            painter = painterResource(id = transaction.icon),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .background(color = transaction.iconBackground)
                .clip(MaterialTheme.shapes.small)
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = transaction.title, style = MaterialTheme.typography.body1)
            Text(text = transaction.date, style = MaterialTheme.typography.caption)
        }
    }
}

@Composable
fun aBottomNavigation(content: @Composable () -> Unit) {
    val items = remember { listOf("Home", "Transactions", "Wallet", "Settings") }
    val selectedItem = remember { mutableStateOf(0) }
    val context = LocalContext.current

    BottomNavigation {
        items.forEachIndexed { index, label ->
            BottomNavigationItem(
                icon = {
                    when (index) {
                        0 -> Icons.Default.Home
                        1 -> Icons.Default.CreditCard
                        2 -> Icons.Default.AccountBalanceWallet
                        3 -> Icons.Default.Settings
                        else -> null
                    }?.let { icon ->
                        Icon(icon, contentDescription = null)
                    }
                },
                label = { Text(label) },
                selected = selectedItem.value == index,
                onClick = {
                    selectedItem.value = index
                    // Handle navigation to different screens based on the index
                    // You can use Navigation component or any other navigation approach here
                    // For simplicity, let's just show a toast
                    showToast(context, "Selected: $label")
                }
            )
        }
    }
}

@Composable
fun showToast(context: android.content.Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

@Composable
fun generateDummyTransactions(count: Int): List<Transaction> {
    val transactions = mutableListOf<Transaction>()
    for (i in 1..count) {
        transactions.add(
            Transaction(
                title = "Transaction $i",
                date = "2023-01-01",
                icon = R.drawable.ic_baseline_monetization_on_24,
                iconBackground = Color.Gray
            )
        )
    }
    return transactions
}

data class Transaction(
    val title: String,
    val date: String,
    val icon: Int,
    val iconBackground: Color
)

@Preview(showBackground = true)
@Composable
fun MoneyManagerAppPreview() {
    FeatherAndroidTasksTheme {
        MoneyManagerApp()
    }
}
