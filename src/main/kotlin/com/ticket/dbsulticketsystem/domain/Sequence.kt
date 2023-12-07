package com.ticket.dbsulticketsystem.domain

import java.time.LocalDateTime
import java.time.LocalDate
import java.time.LocalTime
import javax.persistence.*

@Entity
@Table(name = "sequence", schema = "dp_ticket")
open class Sequence {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Int? = null

    @Column(name = "goods_id")
    open var goodsId: Int = 0

    @Column(name = "place_id")
    open var placeId: Int? = null

    @Column(name = "date")
    open var date: LocalDate? = null

    @Column(name = "time")
    open var time: LocalTime? = null

    @Column(name = "is_free")
    open var isFree: Boolean? = null

    @Column(name = "created_at")
    open var createdAt: LocalDateTime? = null

    @Column(name = "updated_at")
    open var updatedAt: LocalDateTime? = null
}