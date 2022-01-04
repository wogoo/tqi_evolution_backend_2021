package com.wogoo.tqbank.tqbank.events

import com.wogoo.tqbank.tqbank.model.LoanModel
import org.springframework.context.ApplicationEvent

class LoanEvent (
    source: Any,
    val purchaseModel: LoanModel
): ApplicationEvent(source)