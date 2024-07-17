package com.example.justgoserver.domain.review.service

import com.example.justgoserver.domain.review.domain.ReviewEntity
import com.example.justgoserver.domain.review.domain.ReviewRepository
import com.example.justgoserver.domain.review.presentation.dto.CreateReviewRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ReviewService(
    private val reviewRepository: ReviewRepository
) {

    fun createReview(request: CreateReviewRequest, userId: Long): ReviewEntity {
        val review = ReviewEntity(content = request.content!!, scope = request.scope!!, userId = userId)
        return reviewRepository.save(review)
    }

    fun getReview(id: Long): ReviewEntity? {
        return reviewRepository.findById(id).orElse(null)
    }

    fun getAllReview(userId: Long): List<ReviewEntity> {
        return reviewRepository.findByUserId(userId)
    }

    fun deleteReview(id: Long): Boolean {
        return if (reviewRepository.existsById(id)) {
            reviewRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}