package com.ticket.dbsulticketsystem.repository;

import com.ticket.dbsulticketsystem.domain.UserGood
import org.springframework.data.jpa.repository.JpaRepository

interface UserGoodRepository : JpaRepository<UserGood, Int> {
    fun findAllByUserId(userId: Int): List<UserGood>
}