package cmps312.lab3.employeesapp.model



import kotlinx.serialization.Serializable

@Serializable
class Department( var department:String?="") {
    override fun toString() = "$department"

}
