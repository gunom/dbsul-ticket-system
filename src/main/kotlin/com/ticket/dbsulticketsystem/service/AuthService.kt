package com.ticket.dbsulticketsystem.service

interface AuthService {

    fun login(email: String, password: String): String
    fun signup(email: String, password: String): String
}
