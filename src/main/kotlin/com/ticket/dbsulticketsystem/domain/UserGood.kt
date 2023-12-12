package com.ticket.dbsulticketsystem.domain

import java.time.Instant
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "user_goods", schema = "dp_ticket")
open class UserGood (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Int? = 0,

    @Column(name = "user_id", nullable = false)
    open var userId: Int? = null,

    @OneToOne
    @JoinColumn(name = "goods_id")
    open var goods: Goods? = null,

    @Column(name = "created_at")
    open var createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at")
    open var updatedAt: LocalDateTime = LocalDateTime.now()
)