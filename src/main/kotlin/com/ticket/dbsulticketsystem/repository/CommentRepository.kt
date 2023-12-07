package com.ticket.dbsulticketsystem.repository;

import com.ticket.dbsulticketsystem.domain.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<Comment, Int> {
    fun findAllByReviewId(reviewId: Int): List<Comment>
}