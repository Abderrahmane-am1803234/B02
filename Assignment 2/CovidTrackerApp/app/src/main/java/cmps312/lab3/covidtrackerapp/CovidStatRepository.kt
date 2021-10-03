package cmps312.lab3.covidtrackerapp

import android.content.Context
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

object CovidStatRepository {


    var  covidStats = listOf<CovidStat>()



    fun initCovidStat(context: Context):List<CovidStat>{

       // Use 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.
     if ( covidStats.isEmpty()){
            val covidStatJson =
                context.assets.open("covid-data.json")
                    .bufferedReader().use { it.readText() }
             covidStats = Json { ignoreUnknownKeys=true }.decodeFromString(covidStatJson)

        }

        return  covidStats
    }
}