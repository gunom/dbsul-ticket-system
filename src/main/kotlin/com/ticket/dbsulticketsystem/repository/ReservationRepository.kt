package com.ticket.dbsulticketsystem.repository;

import com.ticket.dbsulticketsystem.domain.Reservation
import org.springframework.data.jpa.repository.JpaRepository

interface ReservationRepository : JpaRepository<Reservation, Int> {
    fun findAllByUserId(userId: Int): List<Reservation>
    fun findBySequenceIdAndSeatId(sequenceId: Int, id: Int): Reservation?
}