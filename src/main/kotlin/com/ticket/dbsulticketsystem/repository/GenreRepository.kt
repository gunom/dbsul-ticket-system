package com.ticket.dbsulticketsystem.repository;

import com.ticket.dbsulticketsystem.domain.Genre
import org.springframework.data.jpa.repository.JpaRepository

interface GenreRepository : JpaRepository<Genre, Int> {
}