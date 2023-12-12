package com.ticket.dbsulticketsystem.repository;

import com.ticket.dbsulticketsystem.domain.Section
import org.springframework.data.jpa.repository.JpaRepository

interface SectionRepository : JpaRepository<Section, Int> {
    fun findAllByPlaceId(id: Int): List<Section>
}