package com.wogoo.tqbank.tqbank.controller.request

import com.wogoo.tqbank.tqbank.validation.EmailAvailable
import java.math.BigDecimal
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class PostCustomerRequest (
    @field:NotEmpty(message = "Nome deve ser informado")
    var name: String,

    @field:Email(message = "Email deve ser válido ")
    @EmailAvailable
    var email: String,

    @field:NotEmpty(message = "O cpf deve ser informado")
    var cpf: String,

    @field:NotEmpty(message = "O rg deve ser informado")
    var rg: String,

    @field:NotNull(message = "A renda deve ser informada")
    var income: BigDecimal,

    @field:NotEmpty(message = "A senha deve ser informada")
    var password: String,

    @field:NotEmpty(message = "O CEP deve ser informado")
    var zip: String,

    @field:NotEmpty(message = "O endereço deve ser informadp")
    var address: String,

    @field:NotEmpty(message = "O Pais deve ser informada")
    var country: String,
)

