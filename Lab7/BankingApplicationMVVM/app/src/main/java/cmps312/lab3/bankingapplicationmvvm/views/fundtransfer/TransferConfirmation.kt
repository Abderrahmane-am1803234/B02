package cmps312.lab3.bankingapplicationmvvm.views.fundtransfer

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import cmps312.lab3.bankingapplicationmvvm.Screen
import cmps312.lab3.bankingapplicationmvvm.model.BankingViewModel

@Composable
fun TransferConfirmation(navHostController: NavHostController, bankingViewModel: BankingViewModel) {
    Card(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .fillMaxSize(), elevation = 16.dp) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            bankingViewModel.apply {
                Text(text = "From Account Number:${newTransfer.fromAccountNo}")
                Text(text = "Amount Transfer ${newTransfer.amount}")
                Text(text = "Benefiary Account Number:${newTransfer.beneficiaryAccountNo}")
                Text(text = "Benefiary Name: ${newTransfer.beneficiaryName} ")
            }
            Button(onClick = { bankingViewModel.addTransfer
                navHostController.navigate(Screen.Home.route)

            }) {

            }


        }
    }
}