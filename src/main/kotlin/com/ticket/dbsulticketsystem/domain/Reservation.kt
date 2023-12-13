package com.ticket.dbsulticketsystem.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(
    name = "reservation", schema = "dp_ticket", indexes = [
        Index(name = "user_id", columnList = "user_id"),
        Index(name = "sequence_id", columnList = "sequence_id"),
        Index(name = "seat_id", columnList = "seat_id")
    ]
)
open class Reservation (
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Int? = null,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "user_id")
    open var user: User? = null,

    @Column(name = "sequence_id")
    open var sequenceId: Int = 0,

    @Column(name = "seat_id")
    open var seatId: Int = 0,

    @Column(name = "grade")
    open var grade: String? = null,

    @Column(name = "is_canceled")
    open var isCanceled: Boolean? = false,

    @Column(name = "created_at")
    open var createdAt: LocalDateTime? = null,

    @Column(name = "updated_at")
    open var updatedAt: LocalDateTime? = null,
)