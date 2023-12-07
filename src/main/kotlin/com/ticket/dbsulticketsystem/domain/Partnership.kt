package com.ticket.dbsulticketsystem.domain

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(
    name = "partnership", schema = "dp_ticket", indexes = [
        Index(name = "sponser_id", columnList = "sponser_id")
    ]
)
open class Partnership {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Int? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sponser_id")
    open var sponser: com.ticket.dbsulticketsystem.domain.Sponsor? = null

    @Column(name = "title")
    open var title: String? = null

    @Column(name = "discount_rate", precision = 5, scale = 2)
    open var discountRate: BigDecimal? = null

    @Column(name = "created_at")
    open var createdAt: LocalDateTime? = null

    @Column(name = "updated_at")
    open var updatedAt: LocalDateTime? = null
}