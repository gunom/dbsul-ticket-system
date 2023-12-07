package com.ticket.dbsulticketsystem.controller

import com.ticket.dbsulticketsystem.controller.dto.ReviewRequest
import com.ticket.dbsulticketsystem.domain.Review
import com.ticket.dbsulticketsystem.domain.SecurityUser
import com.ticket.dbsulticketsystem.service.ReviewService
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/review")
class ReviewController(
    private val reviewService: ReviewService,
) {

    @GetMapping("/{goodsId}")
    fun list(@PathVariable goodsId: Int): ResponseEntity<List<Review>> {
        val reviewList = reviewService.getReviewList(goodsId)
        return ResponseEntity.ok(reviewList)
    }

    @PostMapping("")
    fun write(
        @AuthenticationPrincipal user: SecurityUser,
        @RequestBody reviewRequest: ReviewRequest): ResponseEntity<Unit> {
        reviewService.writeReview(
            goodsId = reviewRequest.goodsId,
            title = reviewRequest.title,
            content = reviewRequest.content,
            score = reviewRequest.score,
            userId = user.getId()
        )
        return ResponseEntity.ok().build()
    }

    @GetMapping("/detail/{reviewId}")
    fun detail(@PathVariable reviewId: Int): ResponseEntity<Review> {
        val review = reviewService.getReview(reviewId)
        return ResponseEntity.ok(review)
    }
}