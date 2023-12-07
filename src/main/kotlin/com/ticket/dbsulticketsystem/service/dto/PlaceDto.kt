package com.ticket.dbsulticketsystem.service.dto

import java.io.Serializable
import java.math.BigDecimal
import java.time.LocalDateTime

/**
 * DTO for {@link com.ticket.dbsulticketsystem.domain.Place}
 */
data class PlaceDto(
    val id: Int? = null,
    val locationId: Int? = null,
    val latitude: BigDecimal? = null,
    val longitude: BigDecimal? = null,
    val name: String? = null,
    val address: String? = null,
    val placeTypeName: String? = null,
    val capacity: Int? = null,
    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null,
) : Serializable