package cmps312.lab3.covidtrackerapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun DropDown(options:List<String>,selectedOption:String, onselectedOptionChange :(String)->Unit){

    var expanded by remember {
        mutableStateOf(false)
    }
    Box(modifier= Modifier) {
        IconButton(onClick = { expanded = !expanded }) {
            Row{
                Text(selectedOption)
                Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "")

            }

        }

        DropdownMenu(expanded = expanded, onDismissRequest = {expanded=false }

               , modifier = Modifier
                .fillMaxWidth()
                .background(
                Color.Gray)
        ) {


            options.forEach {
                    option->
                DropdownMenuItem(onClick = { expanded=false

                    onselectedOptionChange(option)
                }, modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Color.Gray)) {
                    Text(text=option)
                }

            }

        }
    }


}
