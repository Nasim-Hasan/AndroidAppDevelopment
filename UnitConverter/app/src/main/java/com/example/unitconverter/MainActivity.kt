package com.example.unitconverter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
                UnitConverter()
            }
        }
    }
}

@Composable
fun UnitConverter() {
    Column {
        /*...Arranges the Components in a Stacked Up Formation...*/
        Text("Unit Converter");
        OutlinedTextField(value ="Enter Value Here" , onValueChange = {});
        Row{
        /*...Arranges the Components in a Side-by-Side Formation...*/
        val context = LocalContext.current;
            Button(onClick = { Toast.makeText(context,"Button Clicked",Toast.LENGTH_SHORT).show()}){
               Text("Click Me!");
           }
        }
        Text("Result");
    }
}

@Preview (showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverter();
}