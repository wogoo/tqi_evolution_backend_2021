package com.wogoo.tqbank.tqbank.controller

import com.wogoo.tqbank.tqbank.controller.request.PostLoanRequest
import com.wogoo.tqbank.tqbank.controller.response.LoanResponse
import com.wogoo.tqbank.tqbank.extension.toLoanModel
import com.wogoo.tqbank.tqbank.extension.toResponse
import com.wogoo.tqbank.tqbank.service.CustomerService
import com.wogoo.tqbank.tqbank.service.LoanService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("loans")
class LoanController(
    private val loanService: LoanService,
    private val customerService: CustomerService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid request: PostLoanRequest) {
        val customer = customerService.findById(request.customerId)
        loanService.create(request.toLoanModel(customer))
    }
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): LoanResponse {
        return loanService.findById(id).toResponse()
    }
}