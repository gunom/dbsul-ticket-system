package com.ticket.dbsulticketsystem.repository;

import com.ticket.dbsulticketsystem.domain.FeaturedGood
import com.ticket.dbsulticketsystem.domain.Goods
import org.springframework.data.jpa.repository.JpaRepository

interface FeaturedGoodRepository : JpaRepository<FeaturedGood, Int> {
}