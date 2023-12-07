package com.ticket.dbsulticketsystem.controller.dto

data class ReviewRequest(
    val goodsId: Int,
    val title: String,
    val content: String,
    val score: Int,
)
