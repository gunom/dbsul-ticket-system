package com.ticket.dbsulticketsystem.service

import com.ticket.dbsulticketsystem.domain.Goods
import com.ticket.dbsulticketsystem.service.dto.GoodsInfo

interface RecommendGoodsService {
    fun getRecommendGoodsList(genreId: Int): List<GoodsInfo.GoodsSimpleDto>
}