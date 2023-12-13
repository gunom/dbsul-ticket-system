package com.ticket.dbsulticketsystem.service.impl

import com.ticket.dbsulticketsystem.domain.Goods
import com.ticket.dbsulticketsystem.domain.Section
import com.ticket.dbsulticketsystem.domain.Sequence
import com.ticket.dbsulticketsystem.domain.UserGood
import com.ticket.dbsulticketsystem.repository.*
import com.ticket.dbsulticketsystem.service.GoodsService
import com.ticket.dbsulticketsystem.service.dto.GoodsInfo
import com.ticket.dbsulticketsystem.service.dto.PriceInfo
import com.ticket.dbsulticketsystem.service.dto.ReservationInfo
import com.ticket.dbsulticketsystem.service.dto.SequenceInfo
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class GoodsServiceImpl(
    private val goodsRepository: GoodsRepository,
    private val likeRepository: LikeRepository,
    private val sequenceRepository: SequenceRepository,
    private val genreRepository: GenreRepository,
    private val placeRepository: PlaceRepository,
    private val userGoodRepository: UserGoodRepository,
    private val reservationRepository: ReservationRepository,
    private val seatRepository: SeatRepository,
    private val sectionRepository: SectionRepository,
) : GoodsService {

    override fun getGoodsList(genreId: Int): List<GoodsInfo.GoodsSimpleDto> {
        val goods = goodsRepository.findAllByGenreId(genreId)
        val dto = goods.map {
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
        return dto
    }

    private fun makeGoodsDto(
        it: Goods,
        sequence: List<Sequence>,
        section: List<Section>,
    ) = GoodsInfo.GoodsDto(
        id = it.id,
        title = it.title,
        placeId = it.place.id,
        placeName = it.place.name,
        startDate = it.startDate,
        endDate = it.endDate,
        genreName = it.genre?.genreName,
        viewRate = it.viewRate,
        goodsImageUrl = it.goodsImageUrl,
        goodsInfo = it.goodsInfo,
        salesInfo = it.salesInfo,
        runningTime = it.runningTime,
        interMissionTime = it.interMissionTime,
        ticketOpenDate = it.bookingOpenDate,
        bookingEndDate = it.bookingEndDate,
        maxBooking = it.maxBooking,
        createdAt = it.createdAt,
        updatedAt = it.updatedAt,
        sequenceList = sequence.map { s ->
            SequenceInfo.SequenceDto(
                date = s.date,
                time = s.time,
                isFree = s.isFree,
                createdAt = s.createdAt,
                updatedAt = s.updatedAt,
            )
        },
        priceList = section.map { s ->
            PriceInfo.PriceDto(
                grade = s.grade,
                price = s.price,
            )
        }
    )

    override fun getGoods(goodsId: Int): GoodsInfo.GoodsDto {
        val goods = goodsRepository.findById(goodsId).orElseThrow()
        val sequence = sequenceRepository.findAllByGoodsId(goodsId)
        val section = sectionRepository.findAllByPlaceId(goods.place.id)
        return makeGoodsDto(goods, sequence, section)
    }

    override fun getPopularGoodsList(genreId: Int): List<GoodsInfo.GoodsSimpleDto> {
        val goodsList =
            goodsRepository.findAllByGenreIdAndBookingEndDateLessThan(genreId, LocalDate.now())
        val goodsIds = goodsList.map { it.id }
        val goodsIdToLikeCount = likeRepository.findAllByGoodsIdIn(goodsIds).groupBy { it.goods.id }
            .mapValues { it.value.size }

        return goodsIds.map { goodsIdToLikeCount[it] to goodsList.first { goods -> goods.id == it } }
            .sortedByDescending { it.first }
            .map { it.second }
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

    override fun registerGoods(
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
    ) {
        val genre = genreRepository.findById(genreId).orElseThrow()
        val place = placeRepository.findById(placeId).orElseThrow()
        val goods = Goods(
            title = title,
            place = place,
            startDate = startDate,
            endDate = endDate,
            genre = genre,
            viewRate = 0.0.toBigDecimal(),
            goodsImageUrl = goodsImageUrl,
            goodsInfo = goodsInfo,
            salesInfo = salesInfo,
            runningTime = runningTime,
            interMissionTime = interMissionTime,
            bookingOpenDate = bookingOpenDate,
            bookingEndDate = bookingEndDate,
            maxBooking = maxBooking,
        )
        val newGoods = goodsRepository.save(goods)
        val userGoods = UserGood(
            userId = userId,
            goods = newGoods,
        )
        userGoodRepository.save(userGoods)
    }

    override fun getSellerGoodsList(userId: Int): List<GoodsInfo.GoodsSimpleDto> {
        val userGoodsList = userGoodRepository.findAllByUserId(userId).map { it.goods }
        return userGoodsList.map {
            GoodsInfo.GoodsSimpleDto(
                id = it?.id,
                title = it?.title,
                startDate = it?.startDate,
                endDate = it?.endDate,
                genreName = it?.genre?.genreName,
                goodsImageUrl = it?.goodsImageUrl,
                placeName = it?.place?.name,
            )
        }
    }

    override fun getGoodsDetailAndReservation(
        userId: Int,
        sequenceId: Int,
        pageNum: Int,
        pageSize: Int,
    ): SequenceInfo.SequenceWithReservationDto {
        val pageable = PageRequest.of(pageNum, pageSize)
        val reservationList = reservationRepository.findAllBySequenceId(sequenceId, pageable)
        val sequence = sequenceRepository.findById(sequenceId).orElseThrow()
        val goods = goodsRepository.findById(sequence.goodsId).orElseThrow()
        return SequenceInfo.SequenceWithReservationDto(
            id = sequenceId,
            goodsName = goods.title,
            placeName = goods.place.name,
            date = sequence.date,
            time = sequence.time,
            reservationList = reservationList.map {
                val seat = seatRepository.findById(it.seatId).orElseThrow()
                ReservationInfo.ReservationSimpleDto(
                    id = it.id,
                    userId = it.user?.id,
                    seatRow = seat.seatRow,
                    seatColumn = seat.seatCol,
                    createdAt = it.createdAt,
                    updatedAt = it.updatedAt,
                    date = sequence.date,
                )
            }
        )
    }
}