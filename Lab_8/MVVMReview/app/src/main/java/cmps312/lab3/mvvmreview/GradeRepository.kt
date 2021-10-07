package cmps312.lab3.mvvmreview

import android.content.Context
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class GradeRepository(private val context: Context) {

    private fun readData(filename:String)=
        context.assets.open(filename).bufferedReader().use{it.readText()}
    fun getGrades()=
        Json.decodeFromString<List<Grades>>(readData("grades.json"))

}