package cmps312.lab3.covidtrackerapp.ui.theme

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import cmps312.lab3.covidtrackerapp.CovidStat


@Composable
fun SearchBox(searchText:String,onSearchTextChange:(String)->Unit ){

    TextField(value = searchText, onValueChange = onSearchTextChange

        ,leadingIcon = {

            Icon( Icons.Default.Search, contentDescription = "search icon")
        },
        trailingIcon = {
            if(searchText.isNotEmpty() && searchText.isNotBlank()){
                IconButton(onClick = { onSearchTextChange("") }) {
                    Icon(Icons.Default.Close, contentDescription = "close icon")
                }
            }
        },singleLine = true,
        shape = RectangleShape




    )
}
@Composable
fun search(covidStats:List<CovidStat>, searchText:String)=

    if(searchText.isNullOrEmpty() ){
        covidStats
    }
    else{

        covidStats.filter {
            it.country.contains(searchText,ignoreCase = true)   //ignore character case




        }
    }
