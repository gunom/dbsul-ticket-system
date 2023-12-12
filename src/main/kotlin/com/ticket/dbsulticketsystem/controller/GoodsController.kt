package com.ticket.dbsulticketsystem.controller

import com.ticket.dbsulticketsystem.controller.dto.GoodsRequest
import com.ticket.dbsulticketsystem.domain.SecurityUser
import com.ticket.dbsulticketsystem.service.GoodsService
import com.ticket.dbsulticketsystem.service.RecommendGoodsService
import com.ticket.dbsulticketsystem.service.dto.GoodsInfo
import com.ticket.dbsulticketsystem.service.dto.SequenceInfo
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*
import javax.websocket.server.PathParam

@RestController
@RequestMapping("/goods")
class GoodsController(
    private val goodsService: GoodsService,
    private val recommendGoodsService: RecommendGoodsService,
) {

    @GetMapping("/list")
    fun list(@RequestParam("genre") genreId: Int): ResponseEntity<List<GoodsInfo.GoodsSimpleDto>> {
        val goodsList = goodsService.getGoodsList(genreId)
        return ResponseEntity.ok(goodsList)
    }

    @GetMapping("/{id}")
    fun detail(@PathVariable id: Int): ResponseEntity<GoodsInfo.GoodsDto> {
        val goods = goodsService.getGoods(id)
        return ResponseEntity.ok(goods)
    }

    @GetMapping("/recommend/{genreId}")
    fun recommend(@PathVariable genreId: Int): ResponseEntity<List<GoodsInfo.GoodsSimpleDto>> {
        val goodsList = recommendGoodsService.getRecommendGoodsList(genreId)
        return ResponseEntity.ok(goodsList)
    }

    @GetMapping("/popular/{genreId}")
    fun popular(@PathVariable genreId: Int): ResponseEntity<List<GoodsInfo.GoodsSimpleDto>> {
        val goodsList = goodsService.getPopularGoodsList(genreId)
        return ResponseEntity.ok(goodsList)
    }

    @PostMapping("/register")
    fun register(
        @AuthenticationPrincipal user: SecurityUser,
        @RequestBody goodsRequest: GoodsRequest
    ){
        if (!user.getSeller()) throw Exception("권한이 없습니다.")
        goodsService.registerGoods(
            title = goodsRequest.title,
            startDate = goodsRequest.startDate,
            endDate = goodsRequest.endDate,
            bookingOpenDate = goodsRequest.bookingOpenDate,
            bookingEndDate = goodsRequest.bookingEndDate,
            runningTime = goodsRequest.runningTime,
            genreId = goodsRequest.genreId,
            placeId = goodsRequest.placeId,
            goodsInfo = goodsRequest.goodsInfo,
            salesInfo = goodsRequest.salesInfo,
            interMissionTime = goodsRequest.interMissionTime,
            goodsImageUrl = goodsRequest.goodsImageUrl,
            userId = user.getId(),
            maxBooking = goodsRequest.maxBooking,
            sequenceTime = goodsRequest.sequenceTime
        )
    }

    @GetMapping("/seller/list")
    fun sellerList(@AuthenticationPrincipal user: SecurityUser): ResponseEntity<List<GoodsInfo.GoodsSimpleDto>> {
        if(!user.getSeller()) throw Exception("권한이 없습니다.")
        val goodsList = goodsService.getSellerGoodsList(user.getId())
        return ResponseEntity.ok(goodsList)
    }

    @GetMapping("/seller/{sequenceId}")
    fun sellerDetail(@AuthenticationPrincipal user: SecurityUser, @PathVariable("sequenceId") id: Int,
                     @PathParam("pageNum") pageNum: Int, @PathParam("pageSize") pageSize: Int
    ): ResponseEntity<SequenceInfo.SequenceWithReservationDto> {
        if(!user.getSeller()) throw Exception("권한이 없습니다.")
        val result = goodsService.getGoodsDetailAndReservation(user.getId(), id, pageNum, pageSize)
        return ResponseEntity.ok(result)
    }

}