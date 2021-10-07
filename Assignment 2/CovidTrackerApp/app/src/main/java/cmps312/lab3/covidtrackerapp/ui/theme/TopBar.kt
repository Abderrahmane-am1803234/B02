package cmps312.lab3.covidtrackerapp.ui.theme

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import cmps312.lab3.covidtrackerapp.SortBy


@Composable

fun TopBar(


    onSortChange: (SortBy) -> Unit

){


    TopAppBar(title = { Text(text = "") }, actions = {
        SortBy(onSortChange = onSortChange)
    }
    )



}