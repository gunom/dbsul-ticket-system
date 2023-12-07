package com.ticket.dbsulticketsystem.repository;

import com.ticket.dbsulticketsystem.domain.Expected
import org.springframework.data.jpa.repository.JpaRepository

interface ExpectedRepository : JpaRepository<Expected, Int> {
}