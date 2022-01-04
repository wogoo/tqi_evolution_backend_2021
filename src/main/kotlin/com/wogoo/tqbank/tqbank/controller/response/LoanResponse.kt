package com.wogoo.tqbank.tqbank.controller.response

import com.wogoo.tqbank.tqbank.enums.LoanStatus
import com.wogoo.tqbank.tqbank.model.CustomerModel
import java.math.BigDecimal
import java.time.LocalDateTime

data class LoanResponse (
    var id: Int? = null,

    var valueLoan: BigDecimal,

    var loanPrice: BigDecimal? = null,

    var installments: Int,

    var firstInstallments: LocalDateTime? = null,

    var customer: CustomerModel? = null,

    var status: LoanStatus? = null
    )