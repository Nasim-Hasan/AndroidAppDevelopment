package com.example.navigationdemo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigationdemo.ui.theme.NavigationDemoTheme

@Composable
fun ThirdScreen(greetings:String,navigationToFirstScreen:()->Unit) {
    Column(modifier = Modifier
        .padding(8.dp)
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text("This is the Third Screen", fontSize = 24.sp);
        Spacer(modifier = Modifier.height(16.dp));
        Text(greetings, fontSize = 24.sp);
        Spacer(modifier = Modifier.height(16.dp));
        Button(onClick={navigationToFirstScreen()}){
            Text("First Screen");
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationThirdDemoPreview() {
    NavigationDemoTheme {
        ThirdScreen("",{});
    }
}