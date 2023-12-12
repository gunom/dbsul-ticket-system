package com.ticket.dbsulticketsystem.controller.dto

import com.ticket.dbsulticketsystem.service.dto.SequenceInfo
import java.io.Serializable
import java.time.LocalDate

data class GoodsRequest(
    val title : String,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val bookingOpenDate: LocalDate,
    val bookingEndDate: LocalDate,
    val runningTime: Int,
    val genreId: Int,
    val placeId: Int,
    val goodsInfo: String,
    val salesInfo: String,
    val interMissionTime: Int,
    val goodsImageUrl: String,
    val maxBooking: Int,
    val sequenceTime: List<SequenceInfo.SequenceDto>
) : Serializable
