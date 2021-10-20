package cmps312.lab3.employeesapp.repository

import android.content.Context
import cmps312.lab3.employeesapp.model.Department
import cmps312.lab3.employeesapp.model.Employee
import cmps312.lab3.employeesapp.model.Position
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class EmployeeRepository (private val context: Context) {

    private fun readData(filename: String) =
        context.assets.open(filename).bufferedReader().use { it.readText() }

    fun getDepartments() = Json.decodeFromString<List<Department>>(readData("department.json"))
    fun getEmployees() = Json.decodeFromString<List<Employee>>(readData("employee.json"))
    fun getPositions() =
        Json.decodeFromString<List<Position>>(readData("position.json"))
}