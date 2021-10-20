package cmps312.lab3.employeesapp

sealed class Screen(val route:String){

    object AddEmployee:Screen(route = "AddEmployee")
    object EmployeeList:Screen(route = "EmployeeList")

}

