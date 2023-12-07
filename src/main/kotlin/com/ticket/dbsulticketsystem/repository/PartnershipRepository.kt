package com.ticket.dbsulticketsystem.repository;

import com.ticket.dbsulticketsystem.domain.Partnership
import org.springframework.data.jpa.repository.JpaRepository

interface PartnershipRepository : JpaRepository<Partnership, Int> {
}