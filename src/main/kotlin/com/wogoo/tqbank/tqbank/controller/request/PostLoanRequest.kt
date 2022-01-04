package com.wogoo.tqbank.tqbank.controller.request

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive
import javax.validation.constraints.Size

data class PostLoanRequest (

    @field:NotNull(message = "O valor do empréstimo deve ser informado")
    @field:Positive
    @JsonAlias("value_loan")
    var valueLoan: BigDecimal,

    @field:NotNull(message = "O número de parcelas deve ser informado")
    @field:Positive
    @Size(max = 60)
    var installments: Int,


//    @field:NotNull(message = "A data da primeira parcela deve ser informada")
//    @JsonAlias("first_installments")
//    val firstInstallments: LocalDateTime,

    @field:NotNull
    @field:Positive
    @JsonAlias("customer_id")
    var customerId: Int
) {
    var tax: Double = 0.06
}
