package com.ticket.dbsulticketsystem.repository;

import com.ticket.dbsulticketsystem.domain.Question
import org.springframework.data.jpa.repository.JpaRepository

interface QuestionRepository : JpaRepository<Question, Int> {
}