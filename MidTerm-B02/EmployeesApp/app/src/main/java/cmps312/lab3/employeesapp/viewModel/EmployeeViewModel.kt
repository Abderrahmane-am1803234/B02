package cmps312.lab3.employeesapp.viewModel

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.AndroidViewModel
import cmps312.lab3.employeesapp.model.Department
import cmps312.lab3.employeesapp.model.Employee
import cmps312.lab3.employeesapp.model.Position
import cmps312.lab3.employeesapp.repository.EmployeeRepository

class EmployeeViewModel  (appContext: Application) : AndroidViewModel(appContext) {

    private val employeeRepository = EmployeeRepository(appContext)

    var departments =
        mutableStateListOf<Department>(*employeeRepository.getDepartments().toTypedArray())

    var employees = mutableStateListOf<Employee>(*employeeRepository.getEmployees().toTypedArray())

    var positions = mutableStateListOf<Position>(*employeeRepository.getPositions().toTypedArray())

    fun addEmployee(employee: Employee) = employees.add(employee)

    fun deleteEmployee(employee: Employee){
        employees.remove(employee)
    }
}