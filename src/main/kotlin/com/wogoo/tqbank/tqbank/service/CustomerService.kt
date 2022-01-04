package com.wogoo.tqbank.tqbank.service

import com.wogoo.tqbank.tqbank.enums.Errors
import com.wogoo.tqbank.tqbank.exception.NotFoundException
import com.wogoo.tqbank.tqbank.model.CustomerModel
import com.wogoo.tqbank.tqbank.repository.CustomerRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository,
    private val bCrypt: BCryptPasswordEncoder
) {
    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContaining(it)
        }
        return customerRepository.findAll().toList()
    }
    fun findById(id: Int): CustomerModel {
        return customerRepository.findById(id).orElseThrow { NotFoundException(Errors.MP2101.message.format(id), Errors.MP2101.code) }
    }

    fun create(customer: CustomerModel) {
        val customerCopy = customer.copy(
            password = bCrypt.encode(customer.password)
        )
        customerRepository.save(customerCopy)
    }
    fun emailAvailable(email: String): Boolean {
        return !customerRepository.existsByEmail(email)
    }
}
