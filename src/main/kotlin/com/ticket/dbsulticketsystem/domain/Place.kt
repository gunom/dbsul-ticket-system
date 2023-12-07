package com.ticket.dbsulticketsystem.domain

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "place", schema = "dp_ticket")
open class Place {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Int? = null

    @Column(name = "location_id")
    open var locationId: Int? = null

    @Column(name = "latitude", precision = 10, scale = 8)
    open var latitude: BigDecimal? = null

    @Column(name = "longitude", precision = 11, scale = 8)
    open var longitude: BigDecimal? = null

    @Column(name = "name")
    open var name: String? = null

    @Column(name = "address")
    open var address: String? = null

    @Column(name = "place_type_name")
    open var placeTypeName: String? = null

    @Column(name = "capacity")
    open var capacity: Int? = null

    @Column(name = "created_at")
    open var createdAt: LocalDateTime? = null

    @Column(name = "updated_at")
    open var updatedAt: LocalDateTime? = null
}