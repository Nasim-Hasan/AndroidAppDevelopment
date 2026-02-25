package com.example.mycoursesapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycoursesapp.ui.theme.MyCoursesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCoursesAppTheme {
                val context = LocalContext.current
                AddDataToDatabase(context)
            }
        }
    }}

    @Composable
    fun AddDataToDatabase(
        context: Context
    ) {

        // variables for text field
        val courseName = remember {
            mutableStateOf(TextFieldValue())
        }
        val courseDuration = remember {
            mutableStateOf(TextFieldValue())
        }
        val courseTracks = remember {
            mutableStateOf(TextFieldValue())
        }
        val courseDescription = remember {
            mutableStateOf(TextFieldValue())
        }

        // column for displaying text fields
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            // initialize database handler
            val dbHandler: DBHandler = DBHandler(context)
            Text(
                text = "SQLite Database in Android",
                color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            // text field for course name
            TextField(
                value = courseName.value,
                onValueChange = { courseName.value = it },
                placeholder = { Text(text = "Enter your course name") },
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(20.dp))

            // text field for course duration
            TextField(
                value = courseDuration.value,
                onValueChange = { courseDuration.value = it },
                placeholder = { Text(text = "Enter your course duration") },
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(20.dp))

            // text field for course tracks
            TextField(
                value = courseTracks.value,
                onValueChange = { courseTracks.value = it },
                placeholder = { Text(text = "Enter your course tracks") },
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(20.dp))

            // text field for course description
            TextField(
                value = courseDescription.value,
                onValueChange = { courseDescription.value = it },
                placeholder = { Text(text = "Enter your course description") },
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(15.dp))

            // button to add a new course
            Button(onClick = {
                // call function to add new course
                dbHandler.addNewCourse(
                    courseName.value.text,
                    courseDuration.value.text,
                    courseDescription.value.text,
                    courseTracks.value.text
                )
                Toast.makeText(context, "Course Added to Database", Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "Add Course to Database", color = Color.White)
            }

            Spacer(modifier = Modifier.height(15.dp))

            // button to open courses list screen
            Button(onClick = {
                val i = Intent(context, ViewCourses::class.java)
                context.startActivity(i)

            }) {
                Text(text = "Read Courses to Database", color = Color.White)
            }

        }
    }





