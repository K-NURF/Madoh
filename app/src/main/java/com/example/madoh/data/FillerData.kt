package com.example.madoh.data

import com.example.madoh.Transaction
import com.example.madoh.TransactionDay
import java.util.Date

object FillerData {
    val transactionsSample: List<TransactionDay> = listOf(
        TransactionDay(
            Date(), listOf(
                Transaction(50.0, "Groceries", "Checking", "Weekly grocery shopping"),
                Transaction(20.0, "Dining", "Credit Card", "Lunch with friends")
            )
        ),
        TransactionDay(
            Date(System.currentTimeMillis() - 1 * 24 * 60 * 60 * 1000), listOf(
                Transaction(30.0, "Entertainment", "Savings", "Movie night"),
                Transaction(15.0, "Transportation", "Debit Card", "Bus fare")
            )
        ),
        TransactionDay(
            Date(System.currentTimeMillis() - 2 * 24 * 60 * 60 * 1000),  listOf(
                Transaction(100.0, "Shopping", "Credit Card", "Clothing purchase"),
                Transaction(40.0, "Groceries", "Checking", "Stocking up for the month")
            )
        ),
        TransactionDay(
            Date(System.currentTimeMillis() - 3 * 24 * 60 * 60 * 1000), listOf(
                Transaction(25.0, "Dining", "Debit Card", "Takeout dinner"),
                Transaction(60.0, "Utilities", "Savings", "Electricity bill")
            )
        ),
        TransactionDay(
            Date(System.currentTimeMillis() - 4 * 24 * 60 * 60 * 1000), listOf(
                Transaction(70.0, "Entertainment", "Credit Card", "Concert tickets"),
                Transaction(45.0, "Shopping", "Checking", "Electronics purchase")
            )
        ),
        TransactionDay(
            Date(System.currentTimeMillis() - 5 * 24 * 60 * 60 * 1000), listOf(
                Transaction(90.0, "Entertainment", "Credit Card", "Concert tickets"),
                Transaction(150.0, "Shopping", "Checking", "Electronics purchase")
            )
        ),
        TransactionDay(
            Date(System.currentTimeMillis() - 6 * 24 * 60 * 60 * 1000), listOf(
                Transaction(1000.0, "Jewelery", "Mpesa", "Hair Vine"),
                Transaction(650.0, "Shopping", "Checking", "Electronics purchase")
            )
        )
    )
}