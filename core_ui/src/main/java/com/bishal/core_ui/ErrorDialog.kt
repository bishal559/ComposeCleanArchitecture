package com.bishal.core_ui

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
/**
 *
 * Created by bishal adhikari on 08/10/2024
 * */
@Composable
fun ErrorDialog(message: String?, onDismiss: () -> Unit) {
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
                onDismiss()
            },
            title = {
                Text(
                    text = "An unexpected error occurred",
                    color = MaterialTheme.colorScheme.onSurface // Updated for M3
                )
            },
            text = {
                message?.let { Text(it, color = MaterialTheme.colorScheme.onSurface) }
            },
            confirmButton = {
                Button(
                    onClick = {
                        openDialog.value = false
                        onDismiss()
                    }
                ) {
                    Text(text = "Dismiss")
                }
            },
            containerColor = MaterialTheme.colorScheme.surface, // Dialog background color in M3
            tonalElevation = 8.dp // Optional: sets elevation for the dialog
        )
    }
}