package com.ticket.dbsulticketsystem.service

import com.ticket.dbsulticketsystem.domain.Review

interface ReviewService {
    fun getReviewList(goodsId: Int): List<Review>
    fun writeReview(goodsId: Int, title: String, content: String, score: Int, userId: Int)
    fun getReview(id: Int): Review
}
