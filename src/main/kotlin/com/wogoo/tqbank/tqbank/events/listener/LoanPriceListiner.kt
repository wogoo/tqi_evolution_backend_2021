package com.wogoo.tqbank.tqbank.events.listener

import com.wogoo.tqbank.tqbank.events.LoanEvent
import com.wogoo.tqbank.tqbank.service.LoanService

import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class LoanPriceListiner(
   private val loanService: LoanService
) {
    @Async
    @EventListener()
     fun listen(loanEvent: LoanEvent) {
        val tax: Double = 4.2
        val loanModel = loanEvent.purchaseModel.copy(
            loanPrice = (BigDecimal(loanEvent.purchaseModel.installments)
                    * loanEvent.purchaseModel.valueLoan) * BigDecimal(tax)
        )
        loanService.update(loanModel)
        println("chamou")
    }
}


