package com.ticket.dbsulticketsystem.repository;

import com.ticket.dbsulticketsystem.domain.Place
import org.springframework.data.jpa.repository.JpaRepository

interface PlaceRepository : JpaRepository<Place, Int> {
}