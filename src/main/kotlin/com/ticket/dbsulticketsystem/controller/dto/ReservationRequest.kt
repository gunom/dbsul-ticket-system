package com.ticket.dbsulticketsystem.controller.dto

data class ReservationRequest(
    val sequenceId: Int,
    val seatRow: Int,
    val seatColumn: Int,
    val placeId: Int,
)
