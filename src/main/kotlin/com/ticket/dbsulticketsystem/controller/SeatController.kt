package com.ticket.dbsulticketsystem.controller

import com.ticket.dbsulticketsystem.service.SeatService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/seat")
class SeatController(
    val seatService: SeatService,
) {
}