package com.wogoo.tqbank.tqbank.controller

import com.wogoo.tqbank.tqbank.controller.request.PostCustomerRequest
import com.wogoo.tqbank.tqbank.controller.response.CustomerResponse
import com.wogoo.tqbank.tqbank.extension.toCustomerModel
import com.wogoo.tqbank.tqbank.extension.toResponse
import com.wogoo.tqbank.tqbank.security.UserCanOnlyAcessTheirOwnResource
import com.wogoo.tqbank.tqbank.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("api/v1/customers")
class CustomerController(private val customerService: CustomerService) {

    @GetMapping("/{id}")
    @UserCanOnlyAcessTheirOwnResource
    fun getCustumer(@PathVariable id: Int): CustomerResponse {
        return customerService.findById(id).toResponse()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid customer: PostCustomerRequest) {
        customerService.create(customer.toCustomerModel())
    }

}
