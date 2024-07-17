package com.example.justgoserver.domain.review.domain

import com.example.justgoserver.global.entity.BaseTimeEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "review")
class ReviewEntity(
    id: Long = 0,
    content: String,
    scope: Int,
    userId: Long
): BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT(8)")
    var id: Long = id
        protected set

    @Column(name = "content", columnDefinition = "VARCHAR(50)")
    var content: String = content
        protected set

    @Column(name = "scope", nullable = false)
    var scope: Int = scope
        protected set

    @Column(name = "user_id", nullable = false)
    var userId: Long = userId
        protected set
}