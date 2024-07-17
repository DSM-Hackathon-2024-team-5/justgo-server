package com.example.justgoserver.domain.user.presentation.dto

data class UserResponse(
    val id: Long,
    val username: String,
    val email: String,
    val exp: Int,
    val level: Int
)
