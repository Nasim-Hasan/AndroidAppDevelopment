package com.example.mycoursesapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class ViewCourses : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                ReadDataFromDatabase(LocalContext.current)
            }
        }
    }
}

@Composable
fun ReadDataFromDatabase(context: Context) {
    // initialize array list
    val courseList: List<CourseModel>

    val dbHandler = DBHandler(context)
    courseList = dbHandler.readCourses()

    // create a lazy column for displaying a list view.
    LazyColumn {
        // set data for each item of listview
        itemsIndexed(courseList) { index, _ ->
            // create card for each item
            Card(
                modifier = Modifier.padding(8.dp),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {
                Column(
                    modifier = Modifier.padding(8.dp).fillMaxWidth(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = courseList[index].courseName,
                        modifier = Modifier.padding(4.dp),
                        color = Color.Black, textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.width(5.dp))

                    Text(
                        text = "Course Tracks : " + courseList[index].courseTracks,
                        modifier = Modifier.padding(4.dp),
                        color = Color.Black, textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.width(5.dp))

                    Text(
                        text = "Course Duration : " + courseList[index].courseDuration,
                        modifier = Modifier.padding(4.dp),
                        color = Color.Black, textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.width(5.dp))

                    Text(
                        text = "Description : " + courseList[index].courseDescription,
                        modifier = Modifier.padding(4.dp),
                        color = Color.Black, textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
  }

