package com.ticket.dbsulticketsystem.service.dto

import java.math.BigDecimal

class PriceInfo{
    data class PriceDto(
        val grade: String,
        val price: BigDecimal,
    )
}
