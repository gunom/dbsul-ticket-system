package com.ticket.dbsulticketsystem.controller

import com.ticket.dbsulticketsystem.controller.dto.CommentRequest
import com.ticket.dbsulticketsystem.domain.Comment
import com.ticket.dbsulticketsystem.domain.SecurityUser
import com.ticket.dbsulticketsystem.service.CommentService
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/comment")
class CommentController(
    private val commentService: CommentService,
) {
    @GetMapping("/{reviewId}")
    fun getCommentList(@PathVariable reviewId: Int): ResponseEntity<List<Comment>> {
        val commentList = commentService.getCommentList(reviewId)
        return ResponseEntity.ok(commentList)
    }


    @PostMapping
    fun postComment(
        @AuthenticationPrincipal user: SecurityUser,
        @RequestBody commentRequest: CommentRequest): ResponseEntity<Unit> {
        commentService.addComment(
            reviewId = commentRequest.reviewId,
            content = commentRequest.content,
            userId = user.getId()
        )
        return ResponseEntity.ok().build()
    }

    @DeleteMapping("/{reviewId}")
    fun deleteComment(@PathVariable reviewId: Int): ResponseEntity<Unit> {
        commentService.deleteComment(reviewId)
        return ResponseEntity.ok().build()
    }
}