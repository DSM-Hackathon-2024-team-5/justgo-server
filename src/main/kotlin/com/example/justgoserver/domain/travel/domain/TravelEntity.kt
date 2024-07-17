package com.example.justgoserver.domain.travel.domain

import com.example.justgoserver.domain.user.domain.UserEntity
import com.example.justgoserver.domain.user.service.UserService
import com.example.justgoserver.global.entity.BaseTimeEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.PreUpdate
import jakarta.persistence.Table

@Entity
@Table(name = "travel")
class TravelEntity(
    id: Long = 0,
    regionName: String,
    spotName: String,
    latitude: Double,
    longitude: Double,
    description: String,
    isVisited: Boolean
): BaseTimeEntity() {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT")
    var id: Long = id
        protected set

    @Column(name = "region_name", columnDefinition = "VARCHAR(40)")
    var regionName: String = regionName
        protected set

    @Column(name = "spot_name", columnDefinition = "VARCHAR(40)")
    var spotName: String = spotName
        protected set

    @Column(name = "latitude", columnDefinition = "DOUBLE")
    var latitude: Double = latitude
        protected set

    @Column(name = "longitude", columnDefinition = "DOUBLE")
    var longitude: Double = longitude
        protected set

    @Column(name = "description", columnDefinition = "VARCHAR(255)")
    var description: String = description
        protected set

    @Column(name = "is_visited", columnDefinition = "TINYINT(2)")
    var isVisited: Boolean = false
        protected set

}
