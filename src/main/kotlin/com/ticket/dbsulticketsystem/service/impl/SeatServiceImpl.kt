package com.ticket.dbsulticketsystem.service.impl

import com.ticket.dbsulticketsystem.repository.SeatRepository
import com.ticket.dbsulticketsystem.service.SeatService
import org.springframework.stereotype.Service

@Service
class SeatServiceImpl(
    val seatRepository: SeatRepository
) : SeatService {

}