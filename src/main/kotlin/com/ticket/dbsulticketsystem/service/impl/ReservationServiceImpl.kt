package com.ticket.dbsulticketsystem.service.impl

import com.ticket.dbsulticketsystem.domain.Reservation
import com.ticket.dbsulticketsystem.repository.GoodsRepository
import com.ticket.dbsulticketsystem.repository.ReservationRepository
import com.ticket.dbsulticketsystem.repository.SeatRepository
import com.ticket.dbsulticketsystem.repository.SequenceRepository
import com.ticket.dbsulticketsystem.service.ReservationService
import com.ticket.dbsulticketsystem.service.dto.GoodsInfo
import com.ticket.dbsulticketsystem.service.dto.ReservationInfo
import com.ticket.dbsulticketsystem.service.dto.SequenceInfo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ReservationServiceImpl(
    private val reservationRepository: ReservationRepository,
    private val seatRepository: SeatRepository,
    private val sequenceRepository: SequenceRepository,
    private val goodsRepository: GoodsRepository,
) : ReservationService {

    override fun getReservationList(userId: Int): List<ReservationInfo.ReservationDto> {
        return reservationRepository.findAllByUserId(userId).map {
            val sequence = sequenceRepository.findById(it.sequenceId).get()
            val sequenceDto = SequenceInfo.SequenceDto(
                date = sequence.date,
                time = sequence.time,
                isFree = sequence.isFree,
                createdAt = sequence.createdAt,
                updatedAt = sequence.updatedAt,
            )
            val goods = goodsRepository.findById(sequence.goodsId).orElseThrow()
            val seat = seatRepository.findById(it.seatId).orElseThrow()
            ReservationInfo.ReservationDto(
                id = it.id,
                userId = it.userId,
                sequence = sequenceDto,
                goodsName = goods.title,
                seatRow = seat.seatRow,
                seatColumn = seat.seatCol,
                placeName = goods.place?.name,
                createdAt = it.createdAt,
                updatedAt = it.updatedAt,
            )
        }
    }

    override fun getReservation(id: Int): ReservationInfo.ReservationSimpleDto {
        val reservation = reservationRepository.findById(id).orElseThrow()
        val sequence = sequenceRepository.findById(reservation.sequenceId).get()
        val sequenceDto = SequenceInfo.SequenceDto(
            date = sequence.date,
            time = sequence.time,
            isFree = sequence.isFree,
            createdAt = sequence.createdAt,
            updatedAt = sequence.updatedAt,
        )
        val goods = goodsRepository.findById(sequence.goodsId).orElseThrow()
        val seat = seatRepository.findById(reservation.seatId).orElseThrow()
        return ReservationInfo.ReservationSimpleDto(
            id = reservation.id,
            userId = reservation.userId,
            date = sequence.date,
            time = sequence.time,
            seatRow = seat.seatRow,
            seatColumn = seat.seatCol,
            createdAt = reservation.createdAt,
            updatedAt = reservation.updatedAt,
        )

    }

    override fun cancelReservation(id: Int) {
        reservationRepository.deleteById(id)
    }

    @Transactional
    override fun createReservation(
        userId: Int,
        sequenceId: Int,
        seatRow: Int,
        seatColumn: Int,
        placeId: Int,
    ) {
        val existSeat = seatRepository.findBySeatRowAndSeatCol(seatRow, seatColumn)
        if (existSeat == null) {
            val seat = seatRepository.save(
                com.ticket.dbsulticketsystem.domain.Seat(
                    placeId = placeId,
                    seatRow = seatRow,
                    seatCol = seatColumn,
                )
            )
            reservationRepository.save(
                Reservation(
                    userId = userId,
                    sequenceId = sequenceId,
                    seatId = seat.id,
                )
            )
        } else {
            val reservation =
                reservationRepository.findBySequenceIdAndSeatId(sequenceId, existSeat.id)
            if (reservation != null) {
                throw Exception("이미 예약된 좌석입니다.")
            }
            reservationRepository.save(
                Reservation(
                    userId = userId,
                    sequenceId = sequenceId,
                    seatId = existSeat.id,
                )
            )
        }
    }
}