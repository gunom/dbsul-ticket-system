package com.ticket.dbsulticketsystem.service

import com.ticket.dbsulticketsystem.domain.Reservation
import com.ticket.dbsulticketsystem.service.dto.ReservationInfo

interface ReservationService {

    fun getReservationList(userId: Int): List<ReservationInfo.ReservationDto>
    fun getReservation(id: Int): ReservationInfo.ReservationDto
    fun cancelReservation(id: Int)
    fun createReservation(userId: Int, sequenceId: Int, seatRow: Int, seatColumn: Int, placeId: Int)
}
