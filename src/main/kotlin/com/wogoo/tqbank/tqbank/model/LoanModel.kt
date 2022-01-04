package com.wogoo.tqbank.tqbank.model

import com.wogoo.tqbank.tqbank.enums.Errors
import com.wogoo.tqbank.tqbank.enums.LoanStatus
import com.wogoo.tqbank.tqbank.exception.BadRequestException
import org.hibernate.type.LocalDateType
import javax.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity(name = "loan")
data class LoanModel  (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(name = "value_loan")
    var valueLoan: BigDecimal,


    @Column(name = "loan_price")
    var loanPrice: BigDecimal? = null,

    @Column
    var installments: Int,

    @Column(name = "first_installments")
    val firstInstallments: LocalDateTime = LocalDateTime.now(),

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: CustomerModel? = null
    ) {
    @Column
    @Enumerated(EnumType.STRING)
    var status: LoanStatus? = null
        set(value) {
            if (field == LoanStatus.CANCELADO || field == LoanStatus.DELETADO)
                throw BadRequestException(Errors.MP2002.message.format(field), Errors.MP2002.code)
            field = value

        }

    constructor(
        id: Int? = null,
        loanPrice: BigDecimal,
        valueLoan: BigDecimal,
        installments: Int,
        firstInstallments: LocalDateTime,
        createdAt: LocalDateTime,
        customer: CustomerModel? = null,
        status: LoanStatus?): this(id, loanPrice, valueLoan, installments, firstInstallments, createdAt, customer) {
        this.status = status
    }
}