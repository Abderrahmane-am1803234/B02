package cmps312.lab3.mvvmreview.view

import androidx.activity.ComponentActivity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel

fun AddStudent(onAddStudent:()->Unit){
    val studentModel = viewModel<StudentViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)
    var name by remember {mutableStateOf("")}
    var expandable by remember {
        mutableStateOf(false)
    }
    var grade1 by remember {
        mutableStateOf("Select Grade")
    }
    var grade by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Add Student")
        
        OutlinedTextField(value = name, onValueChange ={name=it},label = { Text(text = "Name")} )

        Row(modifier = Modifier.clickable { expandable=!expandable }){
            OutlinedTextField(value = grade1, onValueChange = {},
            leadingIcon = { Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription ="" )}
                )
        }
        DropdownMenu(expanded = expandable, onDismissRequest = { expandable=false }) {
            studentModel.grades.forEach { item->
                DropdownMenuItem(onClick = { expandable= false
                grade1 = item.toString()
                    grade = item.grade.toString()

                }

                ) {
                    Text(text = "$item")
                }
                
                Button(onClick = {
                studentModel.setNewStudent(name,grade)
                    studentModel.addStudent()
                    onAddStudent()

                }) {
                    
                    
                    Text(text = "Submit")
                    
                }
                
                
            }
        }
    }

}