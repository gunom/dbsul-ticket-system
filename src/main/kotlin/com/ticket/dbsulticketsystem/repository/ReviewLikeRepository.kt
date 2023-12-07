package com.ticket.dbsulticketsystem.repository;

import com.ticket.dbsulticketsystem.domain.ReviewLike
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewLikeRepository : JpaRepository<ReviewLike, Int> {
}