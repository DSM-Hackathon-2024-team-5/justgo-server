package com.example.justgoserver.domain.travel.presentation.dto

data class TravelResponse(
    val id: Long,
    val regionName: String,
    val spotName: String,
    val latitude: Double,
    val longitude: Double,
    val description: String
)