package com.ticket.dbsulticketsystem.repository;

import com.ticket.dbsulticketsystem.domain.RecommendPlace
import org.springframework.data.jpa.repository.JpaRepository

interface RecommendPlaceRepository : JpaRepository<RecommendPlace, Int> {
}