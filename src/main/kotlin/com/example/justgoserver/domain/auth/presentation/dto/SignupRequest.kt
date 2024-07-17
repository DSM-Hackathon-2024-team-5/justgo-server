package com.example.justgoserver.domain.auth.presentation.dto

import org.jetbrains.annotations.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

data class SignupRequest(

    @field:NotNull("null이 될 수 없습니다.")
    @field:Pattern(
        regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$",
        message = "유효한 이메일 주소여야 합니다."
    )
    val email: String,

    @field:NotNull("null이 될 수 없습니다.")
    @field:Size(min = 2, max = 10, message = "닉네임은 2자 ~ 10자입니다.")
    val username: String,

    @field:NotNull("null이 될 수 없습니다.")
    @field:Pattern(
        regexp = "^(?=.*[A-Z])(?=.*[!@#\\$%\\^&\\*])(?=\\S+$).{8,}$",
        message = "비밀번호는 최소 8자 이상이어야 하며, 대문자와 특수 문자를 최소 1개 이상 포함해야 합니다."
    )
    val password: String
)