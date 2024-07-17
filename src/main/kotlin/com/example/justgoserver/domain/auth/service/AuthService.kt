package com.example.justgoserver.domain.auth.service

import com.example.justgoserver.domain.auth.presentation.dto.LoginRequest
import com.example.justgoserver.domain.auth.presentation.dto.SignupRequest
import com.example.justgoserver.domain.user.domain.UserEntity
import com.example.justgoserver.domain.user.domain.UserRepository
import com.example.justgoserver.domain.user.presentation.dto.UserResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class AuthService(
    private val userRepository: UserRepository
){

    @Transactional(readOnly = true)
    fun login(request: LoginRequest): UserResponse {
        val userEntity = userRepository.findByEmail(request.email)
            ?: throw RuntimeException("User not found")

        if(request.password != userEntity.password) throw RuntimeException("Password mismatch exception")

        return UserResponse(userEntity.id, request.email, userEntity.username, userEntity.exp, userEntity.level)
    }

    @Transactional
    fun signup(request: SignupRequest): UserResponse {
        if (userRepository.existsByEmail(request.email)) throw RuntimeException("Already signup exception")

        val userEntity = userRepository.save(UserEntity(
            email = request.email,
            username = request.username,
            password = request.password,
        ))

        return UserResponse(userEntity.id, request.username, request.email, userEntity.exp, userEntity.level)
    }
}