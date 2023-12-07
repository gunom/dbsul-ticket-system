package com.ticket.dbsulticketsystem.repository;

import com.ticket.dbsulticketsystem.domain.Sequence
import org.springframework.data.jpa.repository.JpaRepository

interface SequenceRepository : JpaRepository<Sequence, Int> {
    fun findAllByGoodsId(id: Int): List<Sequence>
}