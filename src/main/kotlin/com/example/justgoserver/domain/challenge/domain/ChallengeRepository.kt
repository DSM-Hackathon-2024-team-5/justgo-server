package com.example.justgoserver.domain.challenge.domain

import org.springframework.data.jpa.repository.JpaRepository

interface ChallengeRepository : JpaRepository<ChallengeEntity, Long> {
}