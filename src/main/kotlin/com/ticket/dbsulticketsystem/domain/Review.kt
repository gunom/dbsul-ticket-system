package com.ticket.dbsulticketsystem.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(
    name = "review", schema = "dp_ticket", indexes = [
        Index(name = "user_id", columnList = "user_id"),
        Index(name = "goods_id", columnList = "goods_id")
    ]
)
open class Review (
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Int? = null,

    @Column(name="user_id")
    open var userId: Int? = null,

    @Column(name="goods_id")
    open var goodsId: Int? = null,

    @Column(name = "title")
    open var title: String? = null,

    @Lob
    @Column(name = "content")
    open var content: String? = null,

    @Column(name = "score")
    open var score: Int? = null,

    @Column(name = "created_at")
    open var createdAt: LocalDateTime? = null,

    @Column(name = "updated_at")
    open var updatedAt: LocalDateTime? = null,

    @Column(name = "view")
    open var view: Int = 0
)