package com.wogoo.tqbank.tqbank.model

import com.wogoo.tqbank.tqbank.enums.CustomerStatus
import com.wogoo.tqbank.tqbank.enums.Role
import java.math.BigDecimal
import javax.persistence.*

@Entity(name = "customer")
data class CustomerModel (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var name: String,

    @Column
    var email: String,

    @Column
    var cpf: String,

    @Column
    val rg: String,

    @Column
    var income: BigDecimal,

    @Column
    val password: String,

    @Column
    val zip: String,

    @Column
    val address: String,

    @Column
    val country: String,

    @Column
    @Enumerated(EnumType.STRING)
    var status: CustomerStatus,

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Role::class, fetch = FetchType.EAGER)
    @CollectionTable(name = "customer_roles", joinColumns = [JoinColumn(name = "customer_id")])
    var roles: Set<Role> = setOf()

        )