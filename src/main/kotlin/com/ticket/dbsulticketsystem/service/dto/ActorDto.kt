package com.ticket.dbsulticketsystem.service.dto

import java.io.Serializable

/**
 * DTO for {@link com.ticket.dbsulticketsystem.domain.Actor}
 */
data class ActorDto(
    val id: Int? = null,
    val name: String? = null,
    val actorImageUrl: String? = null
) :
    Serializable