package cmps312.lab3.covidtrackerapp

import androidx.compose.foundation.layout.Box
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier


enum class SortBy{
    COUNTRY,ACTIVECASES,TOTALDEATHS,POPULATION

}

@Composable
fun SortBy(onSortChange:(SortBy)->Unit){

    var expanded by remember {

        mutableStateOf(false)
    }


    val sortOptions = mapOf("Sort by Country" to SortBy.COUNTRY,
        "Sort by Active Cases" to SortBy.ACTIVECASES,
        "Sort by Total Deaths" to SortBy.TOTALDEATHS,
    "Sort by  Population" to SortBy.POPULATION)
    Box(modifier= Modifier) {
        IconButton(onClick = { expanded = true }) {
            Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "")
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            sortOptions.forEach {


                    option ->
                DropdownMenuItem(onClick = { expanded = false
                    onSortChange(option.value)

                }) {
                    Text(text = option.key)
                }

            }
        }

    }
}

@Composable
fun Sort(covidStats:List<CovidStat>, sortBy:SortBy)=


    when(sortBy){
        SortBy.COUNTRY -> covidStats.sortedBy { it.country}
        SortBy.ACTIVECASES -> covidStats.sortedBy { it.activeCases  }
        SortBy.TOTALDEATHS ->covidStats.sortedBy { it.totalDeaths }
     SortBy.POPULATION -> covidStats.sortedBy { it.population }


    }
