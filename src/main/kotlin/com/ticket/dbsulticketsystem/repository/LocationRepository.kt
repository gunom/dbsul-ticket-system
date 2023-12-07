package com.ticket.dbsulticketsystem.repository;

import com.ticket.dbsulticketsystem.domain.Location
import org.springframework.data.jpa.repository.JpaRepository

interface LocationRepository : JpaRepository<Location, Int> {
}