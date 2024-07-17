package com.example.justgoserver.domain.auth.presentation.dto

import jakarta.validation.constraints.Pattern

data class LoginRequest(

    @field:Pattern(
        regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$",
        message = "유효한 이메일 주소여야 합니다."
    )
    val email: String,

    @field:Pattern(
        regexp = "^(?=.*[A-Z])(?=.*[!@#\\$%\\^&\\*])(?=\\S+$).{8,}$",
        message = "비밀번호는 최소 8자 이상이어야 하며, 대문자와 특수 문자를 최소 1개 이상 포함해야 합니다."
    )
    val password: String
)