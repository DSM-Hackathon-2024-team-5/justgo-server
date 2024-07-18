package com.example.justgoserver.domain.travel.domain

import com.example.justgoserver.global.entity.BaseTimeEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "travel")
class TravelEntity(
    id: Long = 0,
    regionName: String,
    spotName: String,
    latitude: Double,
    longitude: Double,
    description: String,
): BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
