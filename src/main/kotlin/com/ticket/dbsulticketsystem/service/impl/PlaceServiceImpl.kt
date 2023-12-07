package com.ticket.dbsulticketsystem.service.impl

import com.ticket.dbsulticketsystem.domain.Place
import com.ticket.dbsulticketsystem.repository.PlaceRepository
import com.ticket.dbsulticketsystem.service.PlaceService
import org.springframework.stereotype.Service

@Service
class PlaceServiceImpl(
    val placeRepository: PlaceRepository
): PlaceService {

    override fun getPlaceList(): List<Place> {
        return placeRepository.findAll()
    }

    override fun getPlaceDetail(placeId: Int): Place {
        return placeRepository.findById(placeId).get()
    }
}