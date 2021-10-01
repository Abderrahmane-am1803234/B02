package cmps312.lab3.covidtrackerapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CovidCard(covidStat:CovidStat){

   // val context = LocalContext.current
   // val imagePop = context.resources.getIdentifier(covidStat.population.toString(),"drawable",context.packageName)
val populationImage = painterResource(id = R.drawable.population)
    Card(
        Modifier


            .padding(3.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(19.dp))
            .size(130.dp),
        backgroundColor = Color.LightGray,
        elevation = 15.dp

    ) {
        Row() {
            Image(painter = populationImage, contentDescription = "pop pic",
                Modifier
                    .background(Color.Gray)
                    .align(Alignment.CenterVertically)
                    .padding(9.dp)
                    .size(width = 150.dp, height = 150.dp)
                    .clip(RoundedCornerShape(19.dp))
                // .border(3.dp, Color.Black)

            )
            Column(

                Modifier
                    .padding(7.dp)
                    .align(Alignment.CenterVertically)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = "population\n ${covidStat.population}M")

            }
        }
    }




}
@Preview
@Composable

fun  CovidCardPrv(){
    CovidCard(  CovidStat("vv",9,9,88,9))

   // covidStat(staduim = Stadium("Education city stadium"," Al-Rayyan","To be built","education_city",345))

}