package com.ticket.dbsulticketsystem.repository;

import com.ticket.dbsulticketsystem.domain.ReviewUser
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewUserRepository : JpaRepository<ReviewUser, Int> {
}