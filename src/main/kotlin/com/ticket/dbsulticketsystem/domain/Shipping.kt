package com.ticket.dbsulticketsystem.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(
    name = "shipping", schema = "dp_ticket", indexes = [
        Index(name = "user_id", columnList = "user_id")
    ]
)
open class Shipping {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Int? = null

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "user_id")
    open var user: com.ticket.dbsulticketsystem.domain.User? = null

    @Column(name = "address")
    open var address: String? = null

    @Column(name = "code", length = 10)
    open var code: String? = null

    @Column(name = "created_at")
    open var createdAt: LocalDateTime? = null

    @Column(name = "updated_at")
    open var updatedAt: LocalDateTime? = null
}