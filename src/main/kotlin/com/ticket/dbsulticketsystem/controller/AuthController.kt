package com.ticket.dbsulticketsystem.controller

import com.ticket.dbsulticketsystem.controller.dto.LoginRequest
import com.ticket.dbsulticketsystem.controller.dto.LoginResponseDto
import com.ticket.dbsulticketsystem.service.AuthService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val authService: AuthService
) {
    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest): ResponseEntity<LoginResponseDto> {
        val result = authService.login(loginRequest.email, loginRequest.password)
        return ResponseEntity.ok(LoginResponseDto(result))
    }

    @PostMapping("/signup")
    fun signup(@RequestBody loginRequest: LoginRequest): ResponseEntity<LoginResponseDto> {
        val result = authService.signup(loginRequest.email, loginRequest.password)
        return ResponseEntity.ok(LoginResponseDto(result))
    }
}