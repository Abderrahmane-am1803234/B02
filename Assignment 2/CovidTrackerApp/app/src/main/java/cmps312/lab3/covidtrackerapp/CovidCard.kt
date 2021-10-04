package cmps312.lab3.covidtrackerapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

@Composable
fun CovidCard(covidStat:CovidStat){
    val context = LocalContext.current
 //   val populationImage =R.drawable.population

    val populationImage = context.resources.getIdentifier(R.drawable.population.toString(),"drawable",context.packageName)

   // val context = LocalContext.current
   // val imagePop = context.resources.getIdentifier(covidStat.population.toString(),"drawable",context.packageName)
    // painterResource(id = R.drawable.population)
val countryImage = context.resources.getIdentifier(R.drawable.country.toString(),"drawable",context.packageName)
    //R.drawable.country
   // painterResource(id = R.drawable.country)
  //  context.resources.getIdentifier(R.drawable.country.toString(),"drawable",context.packageName)
val activeCasesImage =context.resources.getIdentifier(R.drawable.activecases.toString(),"drawable",context.packageName)
    //R.drawable.activecases
  //  painterResource(id = R.drawable.activecases)
    
val deadImage =   context.resources.getIdentifier(R.drawable.dead.toString(),"drawable",context.packageName)

   // R.drawable.dead
    //painterResource(id = R.drawable.dead)
val recoveredImage =  context.resources.getIdentifier( R.drawable.recovered.toString(),"drawable",context.packageName)

   // R.drawable.recovered
   // painterResource(id = R.drawable.recovered)
    
    Card(
        Modifier


            .padding(3.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(19.dp))
            .size(230.dp),
        backgroundColor = Color.Yellow,


        elevation = 15.dp

    ) {
        
        Column(
            Modifier
                .fillMaxWidth()
                .padding(3.dp),verticalArrangement = Arrangement.spacedBy(15.dp)) {
            
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(0.dp)
            ) {



                    Image(painter = painterResource(id = countryImage), contentDescription = "country image",Modifier.height(50.dp))
                    Column() {
                        Text(text = "Country",Modifier.padding(2.dp) ,fontSize = 17.sp,color = Color.Gray)
                        Text(text = "${covidStat.country}",color = Color.Gray,fontSize = 28.sp,fontWeight = FontWeight.Bold
                        )

                    }
                }
            Column(verticalArrangement = Arrangement.spacedBy(15.dp),modifier = Modifier.fillMaxWidth()) {

                Row(
                    Modifier
                        .padding(2.dp)
                        .fillMaxWidth(),horizontalArrangement = Arrangement.spacedBy(19.dp)) {




                    Image(painter = painterResource(id = populationImage), contentDescription = "population image",Modifier.height(50.dp))
                    Column() {
                        Text(text = "Population",color = Color.Gray)
                      //  ${String.format("%.2f",bmi).toDouble()
                      var oo=  covidStat.population
                       // var s = String.
                        //val convert=
                        //{String.format("%.1f",covidStat.population.toString().take(3).toDouble()

                        Text(text = "${covidStat.population.toString().take(3) }M",color = Color.Gray,fontSize = 22.sp,fontWeight = FontWeight.Bold
                        )

                    }
                    Image(painter = painterResource(id = activeCasesImage), contentDescription = "active cases mage",Modifier.height(50.dp))
                    Column() {
                        Text(text = "Active Cases",color = Color.Gray)
                        Text(text = "${covidStat.activeCases.toString().take(3)}M",color = Color.Gray,fontSize = 22.sp,fontWeight = FontWeight.Bold
                        )

                    }

                }
                Row(
                    Modifier
                        .padding(4.dp)
                        .fillMaxWidth(),horizontalArrangement = Arrangement.spacedBy(19.dp)) {

                    Image(painter = painterResource(id = deadImage), contentDescription = " dead image",Modifier.height(50.dp))
                    Column() {
                        Text(text = "Total Death",color = Color.Gray)
                        Text(text = "${covidStat.totalDeaths.toString().take(3)}K",color = Color.Gray,fontSize = 22.sp,fontWeight = FontWeight.Bold
                        )

                    }
                    Image(painter = painterResource(id = recoveredImage), contentDescription = "recovered image",Modifier.height(50.dp))
                    Column() {
                        Text(text = "Total Recovered",color = Color.Gray)
                        Text(text = "${covidStat.totalRecovered.toString().take(3)}M",color = Color.Gray,fontSize = 22.sp,fontWeight = FontWeight.Bold
                        )

                    }

                }

            }


            
        }

//        Row() {
//            Image(painter = populationImage, contentDescription = "pop pic",
//                Modifier
//                    .background(Color.Gray)
//                    .align(Alignment.CenterVertically)
//                    .padding(9.dp)
//                    .size(width = 150.dp, height = 150.dp)
//                    .clip(RoundedCornerShape(19.dp))
//                // .border(3.dp, Color.Black)
//
//            )
//            Column(
//
//                Modifier
//                    .padding(7.dp)
//                    .align(Alignment.CenterVertically)
//                    .fillMaxWidth(),
//                verticalArrangement = Arrangement.SpaceEvenly
//            ) {
//                Text(text = "population\n ${covidStat.population}M")
//
//            }
//        }
    }




}
//@Preview
//@Composable
//
//fun  CovidCardPrv(){
//    val covidList = listOf<CovidStat>(CovidStat("United States",187.7,3.5,2.6,331.3),CovidStat("United States",187.7,3.5,2.6,331.3),
//        CovidStat("United States",187.7,3.5,2.6,331.3),CovidStat("United States",187.7,3.5,2.6,331.3)
//        )
//
//    LazyColumn(){
//        items(covidList){
//            CovidCard(it)
//        }
//    }
//    //CovidCard(  CovidStat("United States",187.7,3.5,2.6,331.3))

   // covidStat(staduim = Stadium("Education city stadium"," Al-Rayyan","To be built","education_city",345))

//}