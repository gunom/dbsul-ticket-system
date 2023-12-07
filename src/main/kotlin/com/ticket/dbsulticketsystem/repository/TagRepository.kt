package com.ticket.dbsulticketsystem.repository;

import com.ticket.dbsulticketsystem.domain.Tag
import org.springframework.data.jpa.repository.JpaRepository

interface TagRepository : JpaRepository<Tag, Int> {
}