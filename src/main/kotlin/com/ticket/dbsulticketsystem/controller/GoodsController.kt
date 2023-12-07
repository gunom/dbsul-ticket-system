package com.ticket.dbsulticketsystem.controller

import com.ticket.dbsulticketsystem.service.GoodsService
import com.ticket.dbsulticketsystem.service.RecommendGoodsService
import com.ticket.dbsulticketsystem.service.dto.GoodsInfo
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.websocket.server.PathParam

@RestController
@RequestMapping("/goods")
class GoodsController(
    private val goodsService: GoodsService,
    private val recommendGoodsService: RecommendGoodsService,
) {

    // queryString genre=1
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
}