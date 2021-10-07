package cmps312.lab3.mvvmreview.view

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cmps312.lab3.mvvmreview.Student

@Composable
fun StudentList(onNavigate:()->Unit){

val studentModel = viewModel<StudentViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)
Card(elevation = 18.dp,modifier = Modifier.fillMaxSize()) {


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        val students = studentModel.students.value
        LazyColumn {

            items(students) { student ->
                StudentCard(student = student)
            }
        }
    }
    Column(verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.End) {
        FloatingActionButton(onClick = { onNavigate}
        ,backgroundColor = Color.Blue
        , contentColor = Color.White,modifier = Modifier.size(width = 62.dp,height = 62.dp)
        ) {}
    }
}
}
@Composable
fun StudentCard(student: Student) {

    Card(
        backgroundColor = Color.Gray
    ,modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), elevation = 18.dp

    ) {
        Column() {
            Text(text = "Name: ${student.name}")
            Text(text = "grade: ${student.grade}")

        }

    }

}


