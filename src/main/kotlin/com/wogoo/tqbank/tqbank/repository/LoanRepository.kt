package com.wogoo.tqbank.tqbank.repository

import com.wogoo.tqbank.tqbank.model.LoanModel
import org.springframework.data.jpa.repository.JpaRepository

interface LoanRepository: JpaRepository<LoanModel, Int> {

}
