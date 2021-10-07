package cmps312.lab3.covidtrackerapp.ui.theme

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import cmps312.lab3.covidtrackerapp.SortBy


@Composable

fun TopBar(
   // searchText: String,

   // onSearchTextChange: (String) -> Unit,
    onSortChange: (SortBy) -> Unit
   // stadiumStaustType: String,onStadiumStaustTypeChange:(String)->Unit,
  //  onSortChange: (SortBy) -> Unit
){

//    val types = listOf<String>("All",
//        "To be built",
//        "Major renovation")

    TopAppBar(title = { Text(text = "") }, actions = {
       // SearchBox(searchText = searchText, onSearchTextChange = onSearchTextChange)
        SortBy(onSortChange = onSortChange)
       // DropDown(options = types, selectedOption = stadiumStaustType, onselectedOptionChange =onStadiumStaustTypeChange )
      //  Sort(onSortChange = onSortChange)
    }
    )



}