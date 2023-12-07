package com.ticket.dbsulticketsystem.repository;

import com.ticket.dbsulticketsystem.domain.Shipping
import org.springframework.data.jpa.repository.JpaRepository

interface ShippingRepository : JpaRepository<Shipping, Int> {
}