package cmps312.lab3.covidtrackerapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import cmps312.lab3.covidtrackerapp.ui.theme.SearchBox
import cmps312.lab3.covidtrackerapp.ui.theme.TopBar
import cmps312.lab3.covidtrackerapp.ui.theme.search

@Composable
fun covidStatScreen(){
    var searhText by remember {
        mutableStateOf("")
    }
    var sortBy by remember {
        mutableStateOf(SortBy.ACTIVECASES)
    }
    //val covidStatsList =CovidStatRepository.initCovidStat(LocalContext.current)


    Scaffold (
        topBar = {
            TopBar(
                //searchText = searhText,
                //onSearchTextChange ={searhText=it},
                onSortChange = {sortBy=it}

            )

        },content = {
            Column() {


                SearchBox(searchText = searhText, onSearchTextChange = { searhText = it })
                CovidStatList(
                    CovidStatRepository.initCovidStat(LocalContext.current),
                    searchText = searhText,
                    sortBy = sortBy
                )
            }
        }

    )



}
@Composable
fun CovidStatList(covidStatsList:List<CovidStat>, searchText:String, sortBy: SortBy){
//    covidStatsList:List<CovidStat>, searchText:String, sortBy: SortBy
    var filteredCovidStatsList: List<CovidStat> = search(covidStats = covidStatsList, searchText = searchText)
filteredCovidStatsList= Sort(covidStats = filteredCovidStatsList, sortBy = sortBy )

    Column() {
        //SearchBox(searchText = searchText, onSearchTextChange = {searchText = it })

        LazyColumn() {
            item {
                //  SearchBox(searchText = searchText, onSearchTextChange = {})


            }


            items(filteredCovidStatsList) {
                CovidCard(it)
            }
        }
    }
}

@Preview
@Composable

fun  CovidPrv(){
    covidStatScreen()

}