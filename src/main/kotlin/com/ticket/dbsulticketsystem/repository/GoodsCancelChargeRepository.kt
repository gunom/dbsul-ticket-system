package com.ticket.dbsulticketsystem.repository;

import com.ticket.dbsulticketsystem.domain.GoodsCancelCharge
import org.springframework.data.jpa.repository.JpaRepository

interface GoodsCancelChargeRepository : JpaRepository<GoodsCancelCharge, Int> {
}