package com.ticket.dbsulticketsystem.repository;

import com.ticket.dbsulticketsystem.domain.GoodsTag
import org.springframework.data.jpa.repository.JpaRepository

interface GoodsTagRepository : JpaRepository<GoodsTag, Int> {
}