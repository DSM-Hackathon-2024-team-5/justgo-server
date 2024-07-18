package com.example.justgoserver.domain.travel.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface TravelRepository : JpaRepository<TravelEntity, Long> {

    @Query(value = "SELECT * FROM travel " +
        "WHERE (6371 * acos(cos(radians(:latitude)) * cos(radians(latitude)) * " +
        "cos(radians(longitude) - radians(:longitude)) + sin(radians(:latitude)) * " +
        "sin(radians(latitude)))) <= :radius " +
        "ORDER BY RAND() LIMIT 1", nativeQuery = true)
    fun findRandomSpotWithinRange(latitude: Double, longitude: Double, radius: Double): TravelEntity?
}
