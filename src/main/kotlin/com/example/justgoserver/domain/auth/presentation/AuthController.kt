package com.example.justgoserver.domain.auth.presentation

import com.example.justgoserver.domain.auth.presentation.dto.LoginRequest
import com.example.justgoserver.domain.auth.presentation.dto.SignupRequest
import com.example.justgoserver.domain.auth.service.AuthService
import com.example.justgoserver.domain.user.presentation.dto.UserResponse
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
@Validated
class AuthController(
    private val authService: AuthService
) {

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    fun login(
        @RequestBody @Valid
        request: LoginRequest
    ) : UserResponse {
        return authService.login(request)
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    fun signup(
        @RequestBody @Valid
        request: SignupRequest
    ): UserResponse {
        return authService.signup(request)
    }
}