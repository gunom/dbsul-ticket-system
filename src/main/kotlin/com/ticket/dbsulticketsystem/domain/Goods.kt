package com.ticket.dbsulticketsystem.domain

import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(
    name = "goods", schema = "dp_ticket", indexes = [
        Index(name = "title", columnList = "title", unique = true)
    ]
)
open class Goods (
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Int = 0,

    @Column(name = "title")
    open var title: String? = null,

    @OneToOne
    @JoinColumn(name = "place_id")
    open var place: Place? = null,

    @Column(name = "start_date")
    open var startDate: LocalDate? = null,

    @Column(name = "end_date")
    open var endDate: LocalDate? = null,

    @OneToOne
    @JoinColumn(name = "genre_id")
    open var genre: Genre? = null,

    @Column(name = "viewRate", precision = 5, scale = 2)
    open var viewRate: BigDecimal? = null,

    @Column(name = "goods_image_url")
    open var goodsImageUrl: String? = null,

    @Lob
    @Column(name = "goods_info")
    open var goodsInfo: String? = null,

    @Column(name = "sales_info")
    open var salesInfo: String? = null,

    @Column(name = "running_time")
    open var runningTime: Int? = null,

    @Column(name = "inter_mission_time")
    open var interMissionTime: Int? = null,

    @Column(name = "ticket_open_date")
    open var bookingOpenDate: LocalDate? = null,

    @Column(name = "booking_end_date")
    open var bookingEndDate: LocalDate? = null,

    @Column(name = "max_booking")
    open var maxBooking: Int? = null,

    @Column(name = "created_at")
    open var createdAt: LocalDateTime? = null,

    @Column(name = "updated_at")
    open var updatedAt: LocalDateTime? = null,
)