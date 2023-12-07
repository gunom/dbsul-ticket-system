package com.ticket.dbsulticketsystem.repository;

import com.ticket.dbsulticketsystem.domain.Seat
import org.springframework.data.jpa.repository.JpaRepository

interface SeatRepository : JpaRepository<Seat, Int> {
    fun findBySeatRowAndSeatCol(seatRow: Int, seatColumn: Int): Seat?

}