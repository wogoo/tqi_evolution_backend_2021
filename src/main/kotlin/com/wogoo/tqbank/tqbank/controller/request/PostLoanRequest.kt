package com.wogoo.tqbank.tqbank.controller.request

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

data class PostLoanRequest (
    @field:NotNull(message = "O valor do empréstimo deve ser informado")
    @JsonAlias("value_loan")
    var valueLoan: BigDecimal,

    @field:NotNull(message = "O número de parcelas deve ser informado")
    var installments: Int,

//    @field:NotNull(message = "A data da primeira parcela deve ser informada")
//    @JsonAlias("first_installments")
//    val firstInstallments: LocalDateTime,

    @field:NotNull
    @field:Positive
    @JsonAlias("customer_id")
    var customerId: Int
)
