package cmps312.lab3.employeesapp.view

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import cmps312.lab3.employeesapp.model.Employee
import cmps312.lab3.employeesapp.viewModel.EmployeeViewModel


@Composable
fun EmployeeList(onNavigate:()->Unit){
    val employeeViewModel = viewModel<EmployeeViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)
    Card(Modifier.fillMaxSize(),elevation = 9.dp) {


        Column() {
            LazyColumn {

                items(employeeViewModel.employees){
                        employee -> EmployeeCard(employee,
                onDelete = { employeeViewModel.deleteEmployee(employee) }
                    )
                }




            }
        }

        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            FloatingActionButton(onClick = {
                //TODO nivgate
              onNavigate()

            },backgroundColor = Color.Blue,modifier = Modifier.size(70.dp)) {
                Icon(imageVector = Icons.Default.Add, contentDescription ="", )


            }

        }

    }

}





@Composable
fun EmployeeCard(employee: Employee,onDelete:()->Unit) {
    Card(
        Modifier
            .fillMaxWidth().height(188.dp)
            .padding(9.dp),elevation = 19.dp,backgroundColor = Color.LightGray) {
        Column() {
            Row() {

                Column() {


                    Text(
                        text = "Name: ${employee.name}",
                        modifier = Modifier.padding(9.dp),

                        fontSize = 20.sp
                    )
                    Text(
                        text = "Psotoin: ${employee.position}",
                        modifier = Modifier.padding(9.dp),
                        fontSize = 18.sp
                    )
                    Text(
                        text = "Salary: ${employee.salary}",
                        modifier = Modifier.padding(9.dp),
                        fontSize = 18.sp
                    )
                    Text(
                        text = "Department: ${employee.department}",
                        modifier = Modifier.padding(9.dp),
                        fontSize = 18.sp
                    )
                }

                IconButton(onClick = {
                        onDelete()
                },modifier = Modifier.size(130.dp)) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription ="" )

                }
            }
        }
    }



}
@Preview
@Composable
fun EmployeeListPrv(){

  //  EmployeeList ()
}