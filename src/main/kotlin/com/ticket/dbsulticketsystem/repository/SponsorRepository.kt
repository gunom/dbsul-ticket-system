package com.ticket.dbsulticketsystem.repository;

import com.ticket.dbsulticketsystem.domain.Sponsor
import org.springframework.data.jpa.repository.JpaRepository

interface SponsorRepository : JpaRepository<Sponsor, Int> {
}