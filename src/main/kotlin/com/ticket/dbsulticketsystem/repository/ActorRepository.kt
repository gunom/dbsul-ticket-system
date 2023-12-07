package com.ticket.dbsulticketsystem.repository;

import com.ticket.dbsulticketsystem.domain.Actor
import org.springframework.data.jpa.repository.JpaRepository

interface ActorRepository : JpaRepository<Actor, Int> {
}