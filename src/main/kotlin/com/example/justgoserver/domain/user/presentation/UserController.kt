package com.example.justgoserver.domain.user.presentation

import com.example.justgoserver.domain.user.presentation.dto.UserResponse
import com.example.justgoserver.domain.user.service.UserService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
@Validated
private class UserController(
    private val userService: UserService
) {

    @GetMapping("/{email}")
    fun getProfile(@PathVariable email: String): UserResponse {
        return userService.getProfile(email)
    }
}