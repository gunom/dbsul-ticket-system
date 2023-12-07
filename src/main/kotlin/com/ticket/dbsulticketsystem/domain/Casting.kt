package com.ticket.dbsulticketsystem.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(
    name = "casting", schema = "dp_ticket", indexes = [
        Index(name = "sequence_id", columnList = "sequence_id"),
        Index(name = "actor_id", columnList = "actor_id")
    ]
)
open class Casting {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Int? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sequence_id")
    open var sequence: com.ticket.dbsulticketsystem.domain.Sequence? = null

    @Column(name = "casting_name")
    open var castingName: String? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actor_id")
    open var actor: Actor? = null

    @Column(name = "created_at")
    open var createdAt: LocalDateTime? = null

    @Column(name = "updated_at")
    open var updatedAt: LocalDateTime? = null
}