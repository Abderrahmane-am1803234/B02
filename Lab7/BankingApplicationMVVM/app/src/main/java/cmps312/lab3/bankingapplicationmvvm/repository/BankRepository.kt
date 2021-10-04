package cmps312.lab3.bankingapplicationmvvm.repository

import android.content.Context
import cmps312.lab3.bankingapplicationmvvm.model.Account
import cmps312.lab3.bankingapplicationmvvm.model.Beneficiary
import cmps312.lab3.bankingapplicationmvvm.model.Transfer
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class BankRepository(private val context: Context){

    private fun readData(fileName:String)= context.assets.open(fileName).bufferedReader().use { it.readText() }
    fun getTransfer()= Json.decodeFromString<List<Transfer>>(readData(""))
}