package com.ticket.dbsulticketsystem.service.dto

import java.io.Serializable
import java.time.LocalDateTime

public class ReservationInfo{
    data class ReservationDto(
        val id: Int? = null,
        val userId: Int? = null,
        val sequence: SequenceDto? = null,
        val goods: GoodsInfo.GoodsDto? = null,
        val seatRow: Int? = null,
        val seatColumn: Int? = null,
        val placeName: String? = null,
        val createdAt: LocalDateTime? = null,
        val updatedAt: LocalDateTime? = null,
    ) : Serializable
}
