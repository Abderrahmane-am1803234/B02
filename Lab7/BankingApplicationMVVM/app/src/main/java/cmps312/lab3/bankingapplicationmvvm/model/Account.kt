package cmps312.lab3.bankingapplicationmvvm.model

import kotlinx.serialization.Serializable
@Serializable
data class Account (var type:String, var accountNo:String){
        override fun toString(): String {
                return "$type - $accountNo"
        }


}