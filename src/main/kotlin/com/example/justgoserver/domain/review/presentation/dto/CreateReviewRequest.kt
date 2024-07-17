package com.example.justgoserver.domain.review.presentation.dto

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min

data class CreateReviewRequest(
    val content: String?,

    @field:Min(1)
    @field:Max(5)
    val scope: Int?
)