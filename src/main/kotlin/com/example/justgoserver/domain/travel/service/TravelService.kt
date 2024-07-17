package com.example.justgoserver.domain.travel.service

import com.example.justgoserver.domain.travel.domain.TravelRepository
import com.example.justgoserver.domain.travel.presentation.dto.SpotResponse
import com.example.justgoserver.domain.travel.presentation.dto.TravelResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class TravelService(
    private val travelRepository: TravelRepository
) {

    fun recommendTravelSpotWithinRadius(latitude: Double, longitude: Double, radiusKm: Double): SpotResponse? {
        val maxDistance = radiusKm / 111.32
        val randomLatitude = latitude + (Math.random() * 2 - 1) * maxDistance / 111.32
        val randomLongitude = longitude + (Math.random() * 2 - 1) * maxDistance / 111.32

        val randomSpot = travelRepository.findRandomSpotWithinRange(randomLatitude, randomLongitude, maxDistance)
        randomSpot?.let {
            return SpotResponse(it.id, it.description)
        }
        return null
    }

    fun getVisitedSpot(userId: Long): List<TravelResponse> {
        val visitedSpot = travelRepository.findByIsVisitedTrue()
        return visitedSpot.map {
            TravelResponse(
                it.id,
                it.regionName,
                it.spotName,
                it.latitude,
                it.longitude,
                it.description
            )
        }
    }
}
