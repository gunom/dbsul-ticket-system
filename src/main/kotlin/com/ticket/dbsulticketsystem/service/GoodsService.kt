package com.ticket.dbsulticketsystem.service

import com.ticket.dbsulticketsystem.service.dto.GoodsInfo
import com.ticket.dbsulticketsystem.service.dto.SequenceInfo
import java.time.LocalDate

interface GoodsService {
    fun getGoodsList(genreId: Int): List<GoodsInfo.GoodsSimpleDto>
    fun getGoods(goodsId: Int): GoodsInfo.GoodsDto
    fun getPopularGoodsList(genreId: Int): List<GoodsInfo.GoodsSimpleDto>

    fun registerGoods(
        title: String,
        startDate: LocalDate,
        endDate: LocalDate,
        bookingOpenDate: LocalDate,
        bookingEndDate: LocalDate,
        runningTime: Int,
        genreId: Int,
        placeId: Int,
        goodsInfo: String,
        salesInfo: String,
        interMissionTime: Int,
        goodsImageUrl: String,
        userId: Int,
        maxBooking: Int,
        sequenceTime: List<SequenceInfo.SequenceDto>
    )

    fun getSellerGoodsList(userId: Int): List<GoodsInfo.GoodsSimpleDto>
    fun getGoodsDetailAndReservation(
        userId: Int,
        sequenceId: Int,
        pageNum: Int,
        pageSize: Int,
    ): SequenceInfo.SequenceWithReservationDto
}