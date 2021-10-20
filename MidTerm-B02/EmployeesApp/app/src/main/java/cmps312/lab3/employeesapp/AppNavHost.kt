package cmps312.lab3.employeesapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import cmps312.lab3.employeesapp.view.AddEmployee
import cmps312.lab3.employeesapp.view.EmployeeList

@Composable
fun AppNavHost(navHostController: NavHostController){
    NavHost(navController = navHostController, startDestination = Screen.EmployeeList.route ){

        composable(Screen.EmployeeList.route){
            EmployeeList(
                onNavigate =   { navHostController.navigate(Screen.AddEmployee.route) }
            )
        }
        composable(Screen.AddEmployee.route){
            AddEmployee(

                onNavigate = {
                    navHostController.navigate(Screen.EmployeeList.route)
                }
            )
        }
    }
}