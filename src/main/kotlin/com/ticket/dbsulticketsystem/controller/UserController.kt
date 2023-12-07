package com.ticket.dbsulticketsystem.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
) {

    @PostMapping("/login")
    fun login(): String {
        return "login"
    }

    @PostMapping("/signup")
    fun signup(): String {
        return "signup"
    }
}