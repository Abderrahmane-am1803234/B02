package cmps312.lab3.employeesapp.model

import kotlinx.serialization.Serializable

@Serializable
class Employee(
    var name: String,
    var position: String,
    var salary: String,
    var department: String
)
