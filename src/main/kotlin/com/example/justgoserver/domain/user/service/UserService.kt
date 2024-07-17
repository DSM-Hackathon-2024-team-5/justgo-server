package com.example.justgoserver.domain.user.service

import com.example.justgoserver.domain.user.domain.UserRepository
import com.example.justgoserver.domain.user.presentation.dto.UserResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class UserService(
    private val userRepository: UserRepository,
){

    fun getProfile(email: String): UserResponse {
        val userEntity = userRepository.findByEmail(email)
            ?: throw RuntimeException("User not found")

        return UserResponse(
            id = userEntity.id,
            username = userEntity.username,
            email = userEntity.email,
            exp = userEntity.exp,
            level = userEntity.level
        )
    }
}