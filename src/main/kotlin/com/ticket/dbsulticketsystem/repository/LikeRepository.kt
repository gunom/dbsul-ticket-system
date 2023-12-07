package com.ticket.dbsulticketsystem.repository;

import com.ticket.dbsulticketsystem.domain.Like
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface LikeRepository : JpaRepository<Like, Int> {
    @Query("select l from Like l join fetch l.goods g")
    fun findAllByGoodsIdIn(goodsIds: List<Int>): List<Like>
}