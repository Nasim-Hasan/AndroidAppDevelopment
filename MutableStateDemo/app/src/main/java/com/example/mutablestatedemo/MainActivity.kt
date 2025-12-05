package com.example.mutablestatedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mutablestatedemo.ui.theme.MutableStateDemoTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MutableStateDemoTheme {
               Surface(modifier = Modifier.fillMaxSize(),
                   color = MaterialTheme.colorScheme.background){
                   MutableStateDemo();
               }
            }
        }
    }

    @Composable
    fun MutableStateDemo(){
        val treasuresFound = remember { mutableIntStateOf(0) };
        val direction = remember {mutableStateOf("North")};
        val stormOrTreasure = remember { mutableStateOf("") };

        Column{
            Text(text = "Treasure Found: ${treasuresFound.intValue}");
            Text(text = "Current Direction: ${direction.value}");
            Button(onClick={
                direction.value="East";
                if(Random.nextBoolean()){
                    treasuresFound.intValue++;
                    stormOrTreasure.value = "Found a Treasure!"
                }else{
                    stormOrTreasure.value = "Storm Ahead!"
                }
            }
            ){
                Text(text = "Go East");

            }
            Button(onClick={
                direction.value="West";
                if(Random.nextBoolean()){
                    treasuresFound.intValue++;
                    stormOrTreasure.value = "Found a Treasure!"
                }else{
                    stormOrTreasure.value = "Storm Ahead!"
                }
            }
            ){
                Text(text = "Go West");

            }
            Button(onClick={
                direction.value="North";
                if(Random.nextBoolean()){
                    treasuresFound.intValue++;
                    stormOrTreasure.value = "Found a Treasure!"
                }else{
                    stormOrTreasure.value = "Storm Ahead!"
                }
            }
            ){
                Text(text = "Go North");

            }
            Button(onClick={
                direction.value="South";
                if(Random.nextBoolean()){
                    treasuresFound.intValue++;
                    stormOrTreasure.value = "Found a Treasure!"
                }else{
                    stormOrTreasure.value = "Storm Ahead!"
                }
            }
            ){
                Text(text = "Go South");

            }

            Text(text = stormOrTreasure.value);

        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MutableStateDemoPreview() {
        MutableStateDemo();
    }

}

