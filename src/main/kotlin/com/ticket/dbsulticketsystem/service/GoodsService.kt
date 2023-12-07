package com.ticket.dbsulticketsystem.service

import com.ticket.dbsulticketsystem.service.dto.GoodsInfo

interface GoodsService {
    fun getGoodsList(genreId: Int): List<GoodsInfo.GoodsSimpleDto>
    fun getGoods(goodsId: Int): GoodsInfo.GoodsDto
    fun getPopularGoodsList(genreId: Int): List<GoodsInfo.GoodsSimpleDto>
}