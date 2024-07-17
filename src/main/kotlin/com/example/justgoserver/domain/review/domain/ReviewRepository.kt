package com.example.justgoserver.domain.review.domain

import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository : JpaRepository<ReviewEntity, Long> {

    fun findByUserId(userId: Long): List<ReviewEntity>
}