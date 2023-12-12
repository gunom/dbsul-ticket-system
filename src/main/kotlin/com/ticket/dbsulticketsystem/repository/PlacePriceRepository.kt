package com.ticket.dbsulticketsystem.repository;

import com.ticket.dbsulticketsystem.domain.Section
import org.springframework.data.jpa.repository.JpaRepository

interface PlacePriceRepository : JpaRepository<Section, Int> {
}