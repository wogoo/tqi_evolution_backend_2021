package com.wogoo.tqbank.tqbank.controller.response

import java.math.BigDecimal

data class CustomerResponse(
    var id: Int? = null,

    var name: String,

    var email: String,

    var cpf: String,

    var rg: String,

    var income: BigDecimal,

    var zip: String,

    var address: String,

    var country: String
)