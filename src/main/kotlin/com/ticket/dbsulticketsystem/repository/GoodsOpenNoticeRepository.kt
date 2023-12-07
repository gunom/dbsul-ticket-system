package com.ticket.dbsulticketsystem.repository;

import com.ticket.dbsulticketsystem.domain.GoodsOpenNotice
import org.springframework.data.jpa.repository.JpaRepository

interface GoodsOpenNoticeRepository : JpaRepository<GoodsOpenNotice, Int> {
}