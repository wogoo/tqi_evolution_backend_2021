//package com.wogoo.tqbank.tqbank.controller.mapper
//
//import com.wogoo.tqbank.tqbank.controller.request.PostLoanRequest
//import com.wogoo.tqbank.tqbank.model.LoanModel
//import com.wogoo.tqbank.tqbank.service.CustomerService
//import com.wogoo.tqbank.tqbank.service.LoanService
//import org.springframework.stereotype.Component
//
//@Component
//class LoanMapper(
//    private val loanService: LoanService,
//    private val customerService: CustomerService
//) {
//    fun toModel(request: PostLoanRequest): LoanModel {
//        val customer = customerService.findById(request.customerId)
//        val loans = loanService.finAllByIds(request.loanIds)
//
//        return PurchaseModel(
//            customer = customer,
//            pokes = pokes.toMutableList(),
//            price = pokes.sumOf { it.price }
//        )
//    }
//}