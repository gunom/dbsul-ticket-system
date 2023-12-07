package com.ticket.dbsulticketsystem.repository;

import com.ticket.dbsulticketsystem.domain.Performer
import org.springframework.data.jpa.repository.JpaRepository

interface PerformerRepository : JpaRepository<Performer, Int> {
}