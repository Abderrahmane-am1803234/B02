package cmps312.lab3.bankingapplicationmvvm.model

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import cmps312.lab3.bankingapplicationmvvm.repository.BankRepository

class BankingViewModel(appContext: Context):ViewModel(){
    private val bankRepository = BankRepository(appContext)
    val accounts by lazy { bankRepository.getAccounts() }
    val beneficiaries by lazy { bankRepository.getBeneficiares() }
    var transfers :MutableState<List<Transfer>> =  mutableStateOf(listOf())
    init {
        transfers.value= bankRepository.getTransfer()
    }
    var selectedTransfer by mutableStateOf( Transfer())
    lateinit var newTransfer:Transfer
    val addTransfer = {
        transfers.value?.let {
            transfers.value = it+newTransfer
        }
    }






}