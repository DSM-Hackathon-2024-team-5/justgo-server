package com.example.justgoserver.domain.travel.domain

import com.example.justgoserver.global.entity.BaseTimeEntity
import javax.persistence.*

@Entity
@Table(name = "user_travel_visit")
class UserTravelVisitEntity(
    id: Long = 0,
    userId: Long,
    travel: TravelEntity,
    isVisited: Boolean
) : BaseTimeEntity() {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT")
    var id: Long = id
        protected set

    @Column(name = "user_id", columnDefinition = "BIGINT", nullable = false)
    var userId: Long = userId
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "travel_id", columnDefinition = "BIGINT", nullable = false)
    var travel: TravelEntity = travel
        protected set

    @Column(name = "is_visited", columnDefinition = "TINYINT(1)", nullable = false)
    var isVisited: Boolean = isVisited
        set(value) {
            field = value
        }
}
