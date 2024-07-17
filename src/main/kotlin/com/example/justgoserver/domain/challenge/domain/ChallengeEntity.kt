package com.example.justgoserver.domain.challenge.domain

import com.example.justgoserver.global.entity.BaseTimeEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "challenge")
class ChallengeEntity(
    id: Long = 0,
    point: Int,
    imageUrl: String,
    title: String,
    content: String
) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT(8)")
    var id: Long = id
        protected set

    @Column(name = "imageUrl", columnDefinition = "VARCHAR(250)")
    var imageUrl: String = imageUrl
        protected set

    @Column(name = "title", columnDefinition = "VARCHAR(20)")
    var title: String = title
        protected set

    @Column(name = "point", columnDefinition = "INT")
    var point: Int = point
        protected set

    @Column(name = "content", columnDefinition = "VARCHAR(40)")
    var content: String = content
        protected set
}