package com.wogoo.tqbank.tqbank.extension

import com.wogoo.tqbank.tqbank.controller.request.PostCustomerRequest
import com.wogoo.tqbank.tqbank.controller.request.PostLoanRequest
import com.wogoo.tqbank.tqbank.controller.response.CustomerResponse
import com.wogoo.tqbank.tqbank.controller.response.LoanResponse
import com.wogoo.tqbank.tqbank.controller.response.PageResponse
import com.wogoo.tqbank.tqbank.enums.CustomerStatus
import com.wogoo.tqbank.tqbank.model.CustomerModel
import com.wogoo.tqbank.tqbank.model.LoanModel
import org.springframework.data.domain.Page

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

fun PostLoanRequest.toLoanModel(customer: CustomerModel): LoanModel {
    return LoanModel(
        valueLoan = this.valueLoan,
        installments = this.installments,
        customer = customer
    )
}

fun LoanModel.toResponse(): LoanResponse {
    return LoanResponse(
        id = this.id,
        valueLoan = this.valueLoan,
        loanPrice = this.loanPrice,
        customer = this.customer,
        status = this.status,
        installments = this.installments,

    )
}

fun <T> Page<T>.toPageResponse(): PageResponse<T> {
    return PageResponse(this.content, this.number, this.totalElements, this.totalPages  )
}