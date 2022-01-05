package com.wogoo.tqbank.tqbank.events.listener

import com.wogoo.tqbank.tqbank.events.LoanEvent
import com.wogoo.tqbank.tqbank.service.LoanService

import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.math.RoundingMode

@Component
class LoanPriceListiner(
   private val loanService: LoanService
) {
    @Async
    @EventListener()
     fun listen(loanEvent: LoanEvent) {
        val interest = 1.2
        val loanModel = loanEvent.purchaseModel.copy(
            loanPrice = (
                calculateLoanAmount(loanEvent.purchaseModel.valueLoan, loanEvent.purchaseModel.installments, interest ) + loanEvent.purchaseModel.valueLoan
                    )
        )

        loanService.update(loanModel)
        println("chamou")
    }
}

fun calculateLoanAmount(loanAmount: BigDecimal, loanTerm: Int, interestRate: Double): BigDecimal {
    return loanAmount.multiply(BigDecimal(interestRate / 100)).multiply(BigDecimal(loanTerm)).setScale(3, RoundingMode.HALF_UP)
}
