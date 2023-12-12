package com.ticket.dbsulticketsystem.service.dto

import java.io.Serializable
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class SequenceInfo {
    data class SequenceDto(
        val date: LocalDate? = null,
        val time: LocalTime? = null,
        val isFree: Boolean? = null,
        val createdAt: LocalDateTime? = null,
        val updatedAt: LocalDateTime? = null,
    ) : Serializable

    data class SequenceWithReservationDto(
        val id: Int? = null,
        val goodsName: String? = null,
        val placeName: String? = null,
        val date: LocalDate? = null,
        val time: LocalTime? = null,
        val reservationList: List<ReservationInfo.ReservationSimpleDto> = emptyList(),
    ) : Serializable
}
