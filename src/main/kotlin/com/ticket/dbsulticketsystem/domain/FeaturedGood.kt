package com.ticket.dbsulticketsystem.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(
    name = "featured_goods", schema = "dp_ticket", indexes = [
        Index(name = "goods_id", columnList = "goods_id")
    ]
)
open class FeaturedGood {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Int? = null

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goods_id", nullable = false)
    open var goods: Goods? = null

    @Column(name = "created_at")
    open var createdAt: LocalDateTime? = null

    @Column(name = "updated_at")
    open var updatedAt: LocalDateTime? = null
}