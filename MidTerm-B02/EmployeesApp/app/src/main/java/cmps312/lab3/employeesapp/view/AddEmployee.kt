package cmps312.lab3.employeesapp.view

import androidx.activity.ComponentActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import cmps312.lab3.employeesapp.model.Employee
import cmps312.lab3.employeesapp.viewModel.EmployeeViewModel

@Composable
fun AddEmployee(onNavigate:()->Unit) {

    val employeeViewModel =
        viewModel<EmployeeViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)

    var name by remember { mutableStateOf("") }
    var salary by remember { mutableStateOf("") }
    var department by remember {
        mutableStateOf("")
    }

    var position by remember {
        mutableStateOf("")
    }
    var expandable by remember {
        mutableStateOf(false)
    }
    var expandable2 by remember {
        mutableStateOf(false)
    }
    var department1 by remember {
        mutableStateOf("Select department")
    }
    var position1 by remember {
        mutableStateOf("Select Postion")
    }

    Column(modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "Add Employee",fontSize = 20.sp,fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(10.dp))


        Row(modifier = Modifier.clickable { expandable = !expandable }) {
            OutlinedTextField(
                value = department1,
                onValueChange = {},
                enabled = false,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = ""
                    )
                })
            DropdownMenu(expanded = expandable, onDismissRequest = { expandable = false }) {
                employeeViewModel.departments.forEach { st ->
                    DropdownMenuItem(onClick = {
                        expandable = false
                        department1 = st.toString()
                        department = st.department.toString()


                    }) {
                        Text(text = "$st")
                    }


                }

            }
        }

        Row(modifier = Modifier.clickable { expandable2 = !expandable2 }) {
            OutlinedTextField(
                value = position1,
                onValueChange = {},
                enabled = false,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = ""
                    )
                })
            DropdownMenu(expanded = expandable2, onDismissRequest = { expandable2 = false }) {
               employeeViewModel.positions.forEach { st ->
                    DropdownMenuItem(onClick = {
                        expandable2 = false
                        position1 = st.toString()
                        position = st.position.toString()


                    }) {
                        Text(text = "$st")
                    }


                }

            }
        }
        Spacer(modifier = Modifier.height(13.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Name") })
        Spacer(modifier = Modifier.height(13.dp))

        OutlinedTextField(
            value = salary,
            onValueChange = { salary = it },
            label = { Text(text = "Salary") })


        Spacer(modifier = Modifier.height(13.dp))
        Button(onClick = {

            val newEmployee =Employee(name,position,salary,department)
            employeeViewModel.addEmployee(newEmployee)

            onNavigate()


        }) {
            Text(text = "Submit")
        }

    }


}

@Preview
@Composable
fun AddEmployeePrv() {
  //  AddEmployee()
}