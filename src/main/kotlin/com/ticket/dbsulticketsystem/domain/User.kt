package com.ticket.dbsulticketsystem.domain

import java.time.LocalDateTime
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(
    name = "user", schema = "dp_ticket", indexes = [
        Index(name = "email", columnList = "email", unique = true)
    ]
)
open class User(
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Int = 0,

    @Column(name = "email", nullable = false)
    open var email: String,

    @Column(name = "password", nullable = false)
    open var password: String,

    @Column(name = "birth_date")
    open var birthDate: LocalDate? = null,

    @Column(name = "phone_num", length = 15)
    open var phoneNum: String? = null,

    @Column(name = "name")
    open var name: String? = null,

    @Column(name = "is_seller")
    open var isSeller: Boolean = false,

    @Column(name = "created_at")
    open var createdAt: LocalDateTime? = LocalDateTime.now(),

    @Column(name = "updated_at")
    open var updatedAt: LocalDateTime? = LocalDateTime.now(),
)