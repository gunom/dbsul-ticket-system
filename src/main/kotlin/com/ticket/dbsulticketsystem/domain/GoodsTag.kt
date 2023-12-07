package com.ticket.dbsulticketsystem.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(
    name = "goods_tag", schema = "dp_ticket", indexes = [
        Index(name = "goods_id", columnList = "goods_id"),
        Index(name = "tag_id", columnList = "tag_id")
    ]
)
open class GoodsTag {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Int? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goods_id")
    open var goods: Goods? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    open var tag: com.ticket.dbsulticketsystem.domain.Tag? = null

    @Column(name = "created_at")
    open var createdAt: LocalDateTime? = null

    @Column(name = "updated_at")
    open var updatedAt: LocalDateTime? = null
}