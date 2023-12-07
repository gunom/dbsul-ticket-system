package com.ticket.dbsulticketsystem.service.impl

import com.ticket.dbsulticketsystem.domain.Comment
import com.ticket.dbsulticketsystem.repository.CommentRepository
import com.ticket.dbsulticketsystem.service.CommentService
import org.springframework.stereotype.Service

@Service
class CommentServiceImpl(
    private val commentRepository: CommentRepository
) : CommentService {
    override fun getCommentList(reviewId: Int): List<Comment> {
        return commentRepository.findAllByReviewId(reviewId)
    }

    override fun addComment(reviewId: Int, content: String, userId: Int) {
        val comment = Comment(
            userId = userId,
            reviewId = reviewId,
            content = content
        )
        commentRepository.save(comment)
    }

    override fun deleteComment(reviewId: Int) {
        commentRepository.deleteById(reviewId)
    }

}