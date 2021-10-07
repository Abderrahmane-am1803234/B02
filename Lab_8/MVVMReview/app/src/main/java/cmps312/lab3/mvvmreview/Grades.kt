package cmps312.lab3.mvvmreview

import kotlinx.serialization.Serializable

@Serializable
class Grades (

    var grade:String? =""
        ){

    override fun toString(): String {
        return  "$grade"
    }
}