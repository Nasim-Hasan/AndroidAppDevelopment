package com.example.unitconverterdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverterdemo.ui.theme.UnitConverterDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterDemoTheme {
                 UnitConverterDemo();
            }
        }
    }
}

@Composable
fun UnitConverterDemo(){
      Column (modifier = Modifier.fillMaxSize(),
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center){
          /*...Arranges the Components in a Stacked Up Formation...*/
          Text("Unit Converter");
          Spacer(modifier = Modifier.height(16.dp));
          OutlinedTextField(value ="Enter Value Here" , onValueChange = {});
          Spacer(modifier = Modifier.height(16.dp));
          Row{
          /*...Arranges the Components in a Side-by-Side Formation...*/
              Box{
                  Button(onClick = { /*TODO*/ }) {
                      Text("Select");
                      Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Drop Down");
                  }
              }
              Spacer(modifier = Modifier.width(8.dp));
              Box{
                  Button(onClick = { /*TODO*/ }) {
                      Text("Select");
                      Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Drop Down");
                  }
              }
          }
          Spacer(modifier = Modifier.height(16.dp));
          Text("Result:");
      }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterDemoPreview() {
     UnitConverterDemo();
}