package com.ticket.dbsulticketsystem.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "tag", schema = "dp_ticket")
open class Tag {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Int? = null

    @Column(name = "title")
    open var title: String? = null

    @Column(name = "created_at")
    open var createdAt: LocalDateTime? = null

    @Column(name = "updated_at")
    open var updatedAt: LocalDateTime? = null
}