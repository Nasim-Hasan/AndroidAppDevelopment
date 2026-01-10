package com.example.counterappmvvmrepository

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.counterappmvvmrepository.ui.theme.CounterAppMVVMRepositoryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: CounterViewModel = viewModel();
            CounterAppMVVMRepositoryTheme {
                Surface(modifier = Modifier.fillMaxSize(),color= MaterialTheme.colorScheme.background) {
                    CounterAppMVVMRepository(viewModel);
                }
            }
        }
    }
}

@Composable
fun CounterAppMVVMRepository(viewModel:CounterViewModel) {
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text("Count: ${viewModel.count.value}");
        Spacer(modifier = Modifier.height(16.dp));
        Row{
            Button(onClick = {viewModel.increment()}) {
                Text("Increment");
            }
            Spacer(modifier = Modifier.width(16.dp));
            Button(onClick = {viewModel.decrement()}) {
                Text("Decrement");
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CounterAppMVVMRepositoryThemePreview() {
    CounterAppMVVMRepositoryTheme {
        val viewModel:CounterViewModel = viewModel();
        CounterAppMVVMRepository(viewModel);
    }
}