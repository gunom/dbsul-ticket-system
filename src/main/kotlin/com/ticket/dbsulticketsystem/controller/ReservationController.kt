package com.ticket.dbsulticketsystem.controller

import com.ticket.dbsulticketsystem.controller.dto.ReservationRequest
import com.ticket.dbsulticketsystem.domain.Reservation
import com.ticket.dbsulticketsystem.domain.SecurityUser
import com.ticket.dbsulticketsystem.service.ReservationService
import com.ticket.dbsulticketsystem.service.dto.ReservationInfo
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/reservation")
class ReservationController(
    private val reservationService: ReservationService,
) {

    @GetMapping("/list")
    fun list(
        @AuthenticationPrincipal user: SecurityUser,
    ): ResponseEntity<List<ReservationInfo.ReservationDto>> {
        val reservationList = reservationService.getReservationList(user.getId())
        return ResponseEntity.ok(reservationList)
    }

    @GetMapping("/detail/{id}")
    fun detail(@PathVariable id: Int): ResponseEntity<ReservationInfo.ReservationDto> {
        val reservation = reservationService.getReservation(id)
        return ResponseEntity.ok(reservation)
    }

    @DeleteMapping("/cancel/{id}")
    fun cancel(@PathVariable id: Int): ResponseEntity<Unit> {
        reservationService.cancelReservation(id)
        return ResponseEntity.ok().build()
    }

    @PostMapping("/create")
    fun create(
        @AuthenticationPrincipal user: SecurityUser,
        @RequestBody reservationRequest: ReservationRequest,
    ): ResponseEntity<Unit> {
        reservationService.createReservation(user.getId(), reservationRequest.sequenceId,
            reservationRequest.seatRow, reservationRequest.seatColumn, reservationRequest.placeId
            )
        return ResponseEntity.ok().build()
    }

}