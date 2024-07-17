package com.example.justgoserver.domain.review.presentation

import com.example.justgoserver.domain.review.domain.ReviewEntity
import com.example.justgoserver.domain.review.presentation.dto.CreateReviewRequest
import com.example.justgoserver.domain.review.service.ReviewService
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/review")
@Validated
class ReviewController(
    private val reviewService: ReviewService
) {

    @PostMapping
    fun createReview(
        @RequestBody @Valid request: CreateReviewRequest,
        @RequestParam userId: Long
    ): ResponseEntity<ReviewEntity> {
        val createdReview = reviewService.createReview(request, userId)
        return ResponseEntity.ok(createdReview)
    }

    @GetMapping("/{id}")
    fun getReview(@PathVariable id: Long): ResponseEntity<ReviewEntity?> {
        val review = reviewService.getReview(id)
        return review?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }

    @GetMapping
    fun getAllReview(@RequestParam userId: Long): ResponseEntity<List<ReviewEntity>> {
        val reviews = reviewService.getAllReview(userId)
        return ResponseEntity.ok(reviews)
    }

    @DeleteMapping("/{id}")
    fun deleteReview(@PathVariable id: Long): ResponseEntity<Void> {
        val deleted = reviewService.deleteReview(id)
        return if (deleted) ResponseEntity.noContent().build() else ResponseEntity.notFound().build()
    }
}
