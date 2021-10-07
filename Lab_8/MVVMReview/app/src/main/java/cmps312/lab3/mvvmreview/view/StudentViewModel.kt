package cmps312.lab3.mvvmreview.view

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import cmps312.lab3.mvvmreview.GradeRepository
import cmps312.lab3.mvvmreview.Student

class StudentViewModel(appContext: Application): AndroidViewModel(appContext) {

    private val gradeRepository = GradeRepository(appContext)

    val grades by lazy{gradeRepository.getGrades()}
    val students : MutableState<List<Student>> = mutableStateOf(listOf())

   lateinit var  newStudent:Student
   fun setNewStudent(name:String, grade:String){
       newStudent=Student(name,grade)
   }
   

    val addStudent={
        students.value.let{
            students.value = it + newStudent
        }
    }



}
