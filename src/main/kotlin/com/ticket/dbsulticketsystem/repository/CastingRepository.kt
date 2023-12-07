package com.ticket.dbsulticketsystem.repository;

import com.ticket.dbsulticketsystem.domain.Casting
import org.springframework.data.jpa.repository.JpaRepository

interface CastingRepository : JpaRepository<Casting, Int> {
}