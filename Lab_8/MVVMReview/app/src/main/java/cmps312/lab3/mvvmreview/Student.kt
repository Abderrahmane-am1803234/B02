package cmps312.lab3.mvvmreview

import kotlinx.serialization.Serializable

@Serializable
data class Student (
    var name:String,
    var grade:String
)