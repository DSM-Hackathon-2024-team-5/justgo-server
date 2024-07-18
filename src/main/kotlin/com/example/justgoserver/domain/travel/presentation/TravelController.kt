package com.example.justgoserver.domain.travel.presentation

import com.example.justgoserver.domain.travel.presentation.dto.SpotResponse
import com.example.justgoserver.domain.travel.presentation.dto.TravelResponse
import com.example.justgoserver.domain.travel.service.TravelService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/travel")
class TravelController(
    private val travelService: TravelService
) {

    @GetMapping("/recommend")
    fun recommendTravelSpot(
        @RequestParam userId: Long,
        @RequestParam latitude: Double,
        @RequestParam longitude: Double,
        @RequestParam radiusKm: Double
    ): ResponseEntity<SpotResponse?> {
        val response = travelService.recommendTravelSpotWithinRadius(latitude, longitude, radiusKm, userId)
        return response?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }

    @GetMapping("/visited/{userId}")
    fun getVisitedTravelSpots(@PathVariable userId: Long): ResponseEntity<List<TravelResponse>> {
        val visitedSpot = travelService.getVisitedSpot(userId)
        return ResponseEntity.ok(visitedSpot)
    }
}
