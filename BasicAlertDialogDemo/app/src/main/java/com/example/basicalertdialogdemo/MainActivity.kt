package com.example.basicalertdialogdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.basicalertdialogdemo.ui.theme.BasicAlertDialogDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicAlertDialogDemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BasicAlertDialogDemoApp();
                }
            }
        }
    }
}

@Composable
fun BasicAlertDialogDemoApp() {
    var showDialog by remember { mutableStateOf(false) };
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center){
        Button(onClick = { showDialog=true}, modifier= Modifier.align(Alignment.CenterHorizontally)) {
            Text("Add");
        }
    }
    if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Alert Title")},
                text = {
                    Text("This is a Simple Alert Dialog.");
                },
                confirmButton = {
                    Button(
                        onClick = { showDialog = true}
                    ) {
                        Text("Ok");
                    }
                },
                dismissButton = {
                    Button(
                        onClick = { showDialog = false}
                    ) {
                        Text("Cancel");
                    }
                }
            );
        }

    }

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BasicAlertDialogDemoApp();
}