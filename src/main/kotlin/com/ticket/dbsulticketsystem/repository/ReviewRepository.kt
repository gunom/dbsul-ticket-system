package com.ticket.dbsulticketsystem.repository;

import com.ticket.dbsulticketsystem.domain.Review
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository : JpaRepository<Review, Int> {
    fun findAllByGoodsId(goodsId: Int): List<Review>
}