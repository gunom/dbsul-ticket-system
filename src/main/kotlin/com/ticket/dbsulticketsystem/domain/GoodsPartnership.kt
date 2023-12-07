package com.ticket.dbsulticketsystem.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(
    name = "goods_partnership", schema = "dp_ticket", indexes = [
        Index(name = "goods_id", columnList = "goods_id"),
        Index(name = "partnership_id", columnList = "partnership_id")
    ]
)
open class GoodsPartnership {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Int? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goods_id")
    open var goods: Goods? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partnership_id")
    open var partnership: com.ticket.dbsulticketsystem.domain.Partnership? = null

    @Column(name = "created_at")
    open var createdAt: LocalDateTime? = null

    @Column(name = "updated_at")
    open var updatedAt: LocalDateTime? = null
}