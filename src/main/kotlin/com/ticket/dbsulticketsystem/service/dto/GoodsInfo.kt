package com.ticket.dbsulticketsystem.service.dto

import java.io.Serializable
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

public class GoodsInfo {
    data class GoodsDto(
        val id: Int = 0,
        val title: String? = null,
        val placeId: Int? = null,
        val placeName: String? = null,
        val startDate: LocalDate? = null,
        val endDate: LocalDate? = null,
        val genreName: String? = null,
        val viewRate: BigDecimal? = null,
        val goodsImageUrl: String? = null,
        val goodsInfo: String? = null,
        val salesInfo: String? = null,
        val runningTime: Int? = null,
        val interMissionTime: Int? = null,
        val ticketOpenDate: LocalDate? = null,
        val bookingEndDate: LocalDate? = null,
        val maxBooking: Int? = null,
        val createdAt: LocalDateTime? = null,
        val updatedAt: LocalDateTime? = null,
        val sequenceList: List<SequenceInfo.SequenceDto> = emptyList(),
        val priceList: List<PriceInfo.PriceDto> = emptyList(),
    ) : Serializable

    data class GoodsSimpleDto(
        val id: Int? = null,
        val title: String? = null,
        val genreName: String? = null,
        val startDate: LocalDate? = null,
        val endDate: LocalDate? = null,
        val placeName: String? = null,
        val goodsImageUrl: String? = null,
    ) : Serializable
}
