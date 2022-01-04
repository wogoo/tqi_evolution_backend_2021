package com.wogoo.tqbank.tqbank.service

import com.wogoo.tqbank.tqbank.enums.Errors
import com.wogoo.tqbank.tqbank.events.LoanEvent
import com.wogoo.tqbank.tqbank.exception.NotFoundException
import com.wogoo.tqbank.tqbank.model.LoanModel
import com.wogoo.tqbank.tqbank.repository.LoanRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class LoanService(private val loanRepository: LoanRepository,
                  private val applicationEventPublisher: ApplicationEventPublisher
) {
    fun create(loan: LoanModel) {
        loanRepository.save(loan)
        applicationEventPublisher.publishEvent(LoanEvent(this, loan))
    }

    fun findById(id: Int): LoanModel {
        return loanRepository.findById(id).orElseThrow { NotFoundException(Errors.MP2001.message.format(id), Errors.MP2001.code) }
    }

    fun findAll(pageable: Pageable): Page<LoanModel> {
        return loanRepository.findAll(pageable)
    }
    fun finAllByIds(loanIds: Set<Int>): List<LoanModel> {
        return loanRepository.findAllById(loanIds).toList()
    }
    fun update(loanModel: LoanModel) {
        loanRepository.save(loanModel)

    }

}

private operator fun BigDecimal.times(tax: Double): BigDecimal {
    return BigDecimal(tax)
}
