package cmps312.lab3.nav

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import kotlinx.coroutines.launch
//}




@Composable
fun Navigation(){

    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(route = Screen.DetailScreen.route) {
            DetailScreen()}
        composable(route = Screen.FundTransferScreen.route) {
            FundTransferScreen(navController = navController)

        }
        composable(route = Screen.ConfirmationScreen.route + "/{account_number}/{amount}/{name}/{account_num_ben}",

            arguments = listOf(navArgument("account_number") {

                type = NavType.StringType

                nullable = true
            },
                navArgument("amount") {

                    type = NavType.StringType

                },
                navArgument("name") {

                    type = NavType.StringType

                    nullable = true
                },
                navArgument("account_num_ben") {

                    type = NavType.StringType

                    nullable = true
                }

                )
        ) { entry -> ConfirmationScreen(account_number = entry.arguments?.getString("account_number"),
            amount = entry.arguments?.getString("amount"),
            name = entry.arguments?.getString("name"),
            account_num_ben = entry.arguments?.getString("account_num_ben")


            ) }


    }}










