package com.ticket.dbsulticketsystem.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(
    name = "answer", schema = "dp_ticket", indexes = [
        Index(name = "question_id", columnList = "question_id"),
        Index(name = "user_id", columnList = "user_id")
    ]
)
open class Answer {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Int? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    open var question: com.ticket.dbsulticketsystem.domain.Question? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    open var user: com.ticket.dbsulticketsystem.domain.User? = null

    @Lob
    @Column(name = "contents")
    open var contents: String? = null

    @Column(name = "created_at")
    open var createdAt: LocalDateTime? = null

    @Column(name = "updated_at")
    open var updatedAt: LocalDateTime? = null
}