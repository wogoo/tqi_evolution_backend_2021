package com.wogoo.tqbank.tqbank.extension

import com.wogoo.tqbank.tqbank.controller.request.PostCustomerRequest
import com.wogoo.tqbank.tqbank.controller.response.CustomerResponse
import com.wogoo.tqbank.tqbank.enums.CustomerStatus
import com.wogoo.tqbank.tqbank.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email =  this.email, password = this.password, cpf = this.cpf,
                    rg = this.rg, income = this.income, zip = this.zip, address = this.address, country = this.country, status = CustomerStatus.ATIVO )
}

fun CustomerModel.toResponse(): CustomerResponse {
    return CustomerResponse(
        id = this.id,
        name = this.name,
        email = this.email,
        cpf = this.cpf,
        rg = this.rg,
        income = this.income,
        zip = this.zip,
        address = this.address,
        country = this.country
    )
}