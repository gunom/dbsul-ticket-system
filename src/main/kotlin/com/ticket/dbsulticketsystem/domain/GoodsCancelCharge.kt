package com.ticket.dbsulticketsystem.domain

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(
    name = "goods_cancel_charge", schema = "dp_ticket", indexes = [
        Index(name = "goods_id", columnList = "goods_id")
    ]
)
open class GoodsCancelCharge {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Int? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goods_id")
    open var goods: Goods? = null

    @Column(name = "date_count")
    open var dateCount: Int? = null

    @Column(name = "rate", precision = 5, scale = 2)
    open var rate: BigDecimal? = null

    @Column(name = "created_at")
    open var createdAt: LocalDateTime? = null

    @Column(name = "updated_at")
    open var updatedAt: LocalDateTime? = null
}