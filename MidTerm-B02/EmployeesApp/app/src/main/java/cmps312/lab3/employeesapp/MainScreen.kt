package cmps312.lab3.employeesapp

import androidx.compose.foundation.clickable
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


@Composable
fun MainScreen(){
    val navHostController = rememberNavController()
    val currentRoute = navHostController
        .currentBackStackEntryAsState()?.value?.destination?.route

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    if(currentRoute == Screen.EmployeeList.route)
                    Text(text = "Employees List")
                    else
                        Text(text = "Add Employee ")


                },
                navigationIcon = {
                    if (currentRoute != Screen.EmployeeList.route)
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "",
                            modifier = Modifier.clickable(onClick = { navHostController.navigateUp() })
                        )
                }
            )
        },content = {
            AppNavHost(navHostController = navHostController)

        }
    )





}