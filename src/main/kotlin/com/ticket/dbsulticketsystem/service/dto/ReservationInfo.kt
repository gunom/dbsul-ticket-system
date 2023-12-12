package com.ticket.dbsulticketsystem.service.dto

import java.io.Serializable
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

public class ReservationInfo{
    data class ReservationDto(
        val id: Int? = null,
        val userId: Int? = null,
        val sequence: SequenceInfo.SequenceDto? = null,
        val goodsName: String? = null,
        val seatRow: Int? = null,
        val seatColumn: Int? = null,
        val placeName: String? = null,
        val createdAt: LocalDateTime? = null,
        val updatedAt: LocalDateTime? = null,
    ) : Serializable

    data class ReservationSimpleDto(
        val id: Int? = null,
        val userId: Int? = null,
        val seatRow: Int? = null,
        val seatColumn: Int? = null,
        val createdAt: LocalDateTime? = null,
        val updatedAt: LocalDateTime? = null,
        val time: LocalTime? = null,
        val date: LocalDate? = null,
    )
}
