package cmps312.lab3.employeesapp.model




import kotlinx.serialization.Serializable

@Serializable
class Position (var position:String?=""){
    override fun toString() = "$position"
}