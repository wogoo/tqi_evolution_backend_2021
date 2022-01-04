package com.wogoo.tqbank.tqbank.service

import com.wogoo.tqbank.tqbank.enums.Errors
import com.wogoo.tqbank.tqbank.exception.NotFoundException
import com.wogoo.tqbank.tqbank.model.LoanModel
import com.wogoo.tqbank.tqbank.repository.LoanRepository
import org.springframework.stereotype.Service

@Service
class LoanService(private val loanRepository: LoanRepository) {
    fun create(poke: LoanModel) {
        loanRepository.save(poke)
    }

    fun findById(id: Int): LoanModel {
        return loanRepository.findById(id).orElseThrow { NotFoundException(Errors.MP2001.message.format(id), Errors.MP2001.code) }
    }
}
