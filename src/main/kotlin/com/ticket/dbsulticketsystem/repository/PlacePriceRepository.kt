package com.ticket.dbsulticketsystem.repository;

import com.ticket.dbsulticketsystem.domain.PlacePrice
import org.springframework.data.jpa.repository.JpaRepository

interface PlacePriceRepository : JpaRepository<PlacePrice, Int> {
}