package com.ticket.dbsulticketsystem.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(
    name = "likes", schema = "dp_ticket", indexes = [
        Index(name = "user_id", columnList = "user_id"),
        Index(name = "goods_id", columnList = "goods_id")
    ]
)
open class Like (
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Int? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    open var user: com.ticket.dbsulticketsystem.domain.User? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goods_id", nullable = false)
    open var goods: Goods,

    @Column(name = "created_at")
    open var createdAt: LocalDateTime? = null,

    @Column(name = "updated_at")
    open var updatedAt: LocalDateTime? = null
)