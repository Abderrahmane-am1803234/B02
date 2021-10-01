package cmps312.lab3.covidtrackerapp

import kotlinx.serialization.Serializable

@Serializable
data class CovidStat(


    var country: String,
    var totalDeaths: Int,
    var totalRecovered: Int,
    var activeCases: Int,
    var population: Int,
)