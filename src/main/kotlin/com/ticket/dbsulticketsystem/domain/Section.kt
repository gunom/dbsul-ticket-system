package com.ticket.dbsulticketsystem.domain

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "section", schema = "dp_ticket")
open class Section {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Int? = null

    @Column(name = "place_id")
    open var placeId: Int? = null

    @Column(name = "grade")
    open var grade: String = ""

    @Column(name = "price", precision = 10, scale = 2)
    open var price: BigDecimal = BigDecimal.ZERO

    @Column(name = "start_row")
    open var startRow: Int? = null

    @Column(name = "end_row")
    open var endRow: Int? = null

    @Column(name = "start_col")
    open var startCol: Int? = null

    @Column(name = "end_col")
    open var endCol: Int? = null

    @Column(name = "created_at")
    open var createdAt: LocalDateTime? = null

    @Column(name = "updated_at")
    open var updatedAt: LocalDateTime? = null
}