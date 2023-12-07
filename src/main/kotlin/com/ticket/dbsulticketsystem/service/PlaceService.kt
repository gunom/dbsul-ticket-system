package com.ticket.dbsulticketsystem.service

import com.ticket.dbsulticketsystem.domain.Place

interface PlaceService {

    fun getPlaceList(): List<Place>
    fun getPlaceDetail(placeId: Int): Place
}
