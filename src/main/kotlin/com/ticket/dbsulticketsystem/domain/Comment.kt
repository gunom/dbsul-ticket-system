package com.ticket.dbsulticketsystem.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(
    name = "comment", schema = "dp_ticket", indexes = [
        Index(name = "review_id", columnList = "review_id"),
        Index(name = "user_id", columnList = "user_id")
    ]
)
open class Comment (
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Int? = null,

    @Column(name = "review_id")
    open var reviewId: Int? = null,

    @Column(name = "user_id")
    open var userId: Int? = null,

    @Lob
    @Column(name = "content")
    open var content: String? = null,

    @Column(name = "created_at")
    open var createdAt: LocalDateTime? = null,

    @Column(name = "updated_at")
    open var updatedAt: LocalDateTime? = null,
)