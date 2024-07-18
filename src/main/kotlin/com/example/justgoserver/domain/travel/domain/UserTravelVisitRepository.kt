package com.example.justgoserver.domain.travel.domain

import org.springframework.data.jpa.repository.JpaRepository

interface UserTravelVisitRepository : JpaRepository<UserTravelVisitEntity, Long> {

    fun findByUserIdAndIsVisitedTrue(userId: Long): List<UserTravelVisitEntity>

    fun findByUserIdAndTravelId(userId: Long, travelId: Long): UserTravelVisitEntity?

}