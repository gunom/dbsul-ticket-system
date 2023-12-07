package com.ticket.dbsulticketsystem.repository;

import com.ticket.dbsulticketsystem.domain.GoodsPartnership
import org.springframework.data.jpa.repository.JpaRepository

interface GoodsPartnershipRepository : JpaRepository<GoodsPartnership, Int> {
}