package com.example.navigationdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationdemo.ui.theme.NavigationDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationDemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    NavigationApp();
                }
            }
        }
    }
}

@Composable
fun NavigationApp(){
    val navController = rememberNavController();
    NavHost(navController=navController, startDestination="FirstScreen"){
           composable("FirstScreen") {
               FirstScreen{ name, age->
                   navController.navigate("SecondScreen/$name/$age");
               }
           }
           composable(route="SecondScreen/{name}/{age}") {
               val name = it.arguments?.getString("name")?:" ";
               val age = it.arguments?.getString("age")?:" ";
               SecondScreen (name,age.toInt()) {greetings->
                   navController.navigate("ThirdScreen/$greetings");
               }
           }
           composable(route="ThirdScreen/{greetings}") {
               val greetings = it.arguments?.getString("greetings")?:" ";
               ThirdScreen (greetings) {
                navController.navigate("FirstScreen");
            }
        }
    }
}