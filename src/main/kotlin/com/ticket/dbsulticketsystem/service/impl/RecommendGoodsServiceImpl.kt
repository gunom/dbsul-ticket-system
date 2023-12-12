package com.ticket.dbsulticketsystem.service.impl

import com.ticket.dbsulticketsystem.domain.Goods
import com.ticket.dbsulticketsystem.repository.FeaturedGoodRepository
import com.ticket.dbsulticketsystem.service.RecommendGoodsService
import com.ticket.dbsulticketsystem.service.dto.GoodsInfo
import org.springframework.stereotype.Service

@Service
class RecommendGoodsServiceImpl(
    private val featuredGoodsRepository: FeaturedGoodRepository,
): RecommendGoodsService {
    override fun getRecommendGoodsList(genreId: Int): List<GoodsInfo.GoodsSimpleDto> {
        val featuredGoods = featuredGoodsRepository.findAll()
        return featuredGoods.map { it.goods }.filter { it?.genre?.id == genreId }.mapNotNull { it }
            .map {
                GoodsInfo.GoodsSimpleDto(
                    id = it.id,
                    title = it.title,
                    startDate = it.startDate,
                    endDate = it.endDate,
                    genreName = it.genre?.genreName,
                    goodsImageUrl = it.goodsImageUrl,
                    placeName = it.place.name,
                )
            }
    }
}