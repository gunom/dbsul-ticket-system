package com.ticket.dbsulticketsystem.repository;

import com.ticket.dbsulticketsystem.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Int> {
    fun findByEmail(email: String): User?
}