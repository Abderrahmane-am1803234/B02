package cmps312.lab3.bankingapplicationmvvm.model

import kotlinx.serialization.Serializable
import java.security.SecureRandom

class Transfer(
    var fromAccountNo: String? = "",
    var amount: Double? = 0.0,

    var beneficiaryName: String? = "",
    var beneficiaryAccountNo: String? = "",
    var transferId: Int? = 0
)