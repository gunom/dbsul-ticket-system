package com.ticket.dbsulticketsystem.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(
    name = "payment", schema = "dp_ticket", indexes = [
        Index(name = "reservation_id", columnList = "reservation_id")
    ]
)
open class Payment {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Int? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id")
    open var reservation: com.ticket.dbsulticketsystem.domain.Reservation? = null

    @Column(name = "payment_type")
    open var paymentType: String? = null

    @Column(name = "is_valid")
    open var isValid: Boolean? = null

    @Column(name = "is_canceled")
    open var isCanceled: Boolean? = null

    @Column(name = "created_at")
    open var createdAt: LocalDateTime? = null

    @Column(name = "updated_at")
    open var updatedAt: LocalDateTime? = null
}