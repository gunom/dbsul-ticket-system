package com.ticket.dbsulticketsystem.service.dto

import java.io.Serializable
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

data class SequenceDto(
    val id: Int? = null,
    val date: LocalDate? = null,
    val time: LocalTime? = null,
    val isFree: Boolean? = null,
    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null,
) : Serializable