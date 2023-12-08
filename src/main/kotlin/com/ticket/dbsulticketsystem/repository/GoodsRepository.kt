package com.ticket.dbsulticketsystem.repository;

import com.ticket.dbsulticketsystem.domain.Goods
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.time.LocalDate
import java.util.*

interface GoodsRepository : JpaRepository<Goods, Int> {
    @Query("select g from Goods g join fetch g.genre join fetch g.place where g.genre.id = :genreId")
    fun findAllByGenreId(genreId: Int): List<Goods>
    @Query("select g from Goods g join fetch g.genre join fetch g.place where g.genre.id = :genreId and g.bookingEndDate > :now")
    fun findAllByGenreIdAndBookingEndDateLessThan(genreId: Int, now: LocalDate): List<Goods>

    @EntityGraph(attributePaths = ["genre", "place"], type = EntityGraph.EntityGraphType.FETCH)
    @Query("select g from Goods g  join g.genre join g.place where g.id = :id")
    override fun findById(id: Int): Optional<Goods>
}