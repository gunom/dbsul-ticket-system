package com.ticket.dbsulticketsystem.service

import com.ticket.dbsulticketsystem.domain.Comment

interface CommentService {
    fun getCommentList(reviewId: Int): List<Comment>
    fun addComment(reviewId: Int, content: String, userId: Int)
    fun deleteComment(reviewId: Int)
}
