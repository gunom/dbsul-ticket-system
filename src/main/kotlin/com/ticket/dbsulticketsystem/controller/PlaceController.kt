package com.ticket.dbsulticketsystem.controller

import com.ticket.dbsulticketsystem.domain.Place
import com.ticket.dbsulticketsystem.service.PlaceService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/place")
class PlaceController(
    private val placeService: PlaceService,
) {

    @GetMapping("/list")
    fun getPlaceList(): ResponseEntity<List<Place>> {
        val placeList = placeService.getPlaceList()
        return ResponseEntity.ok(placeList)
    }

    @GetMapping("/{placeId}")
    fun getPlaceDetail(@PathVariable placeId: Int): ResponseEntity<Place> {
        val place = placeService.getPlaceDetail(placeId)
        return ResponseEntity.ok(place)
    }
}