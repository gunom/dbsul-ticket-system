package com.ticket.dbsulticketsystem.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "seat", schema = "dp_ticket")
open class Seat (
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Int = 0,

    @Column(name = "place_id")
    open var placeId: Int? = null,

    @Column(name = "seat_row")
    open var seatRow: Int? = null,

    @Column(name = "seat_col")
    open var seatCol: Int? = null,

    @Column(name = "created_at")
    open var createdAt: LocalDateTime? = null,

    @Column(name = "updated_at")
    open var updatedAt: LocalDateTime? = null,
)