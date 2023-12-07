package com.ticket.dbsulticketsystem.repository;

import com.ticket.dbsulticketsystem.domain.Payment
import org.springframework.data.jpa.repository.JpaRepository

interface PaymentRepository : JpaRepository<Payment, Int> {
}