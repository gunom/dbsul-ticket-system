package com.ticket.dbsulticketsystem.repository;

import com.ticket.dbsulticketsystem.domain.Answer
import org.springframework.data.jpa.repository.JpaRepository

interface AnswerRepository : JpaRepository<Answer, Int> {
}