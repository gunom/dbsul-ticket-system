package com.ticket.dbsulticketsystem.service.impl

import com.ticket.dbsulticketsystem.domain.SecurityUser
import com.ticket.dbsulticketsystem.domain.User
import com.ticket.dbsulticketsystem.jwt.JwtTokenProvider
import com.ticket.dbsulticketsystem.repository.UserRepository
import com.ticket.dbsulticketsystem.service.AuthService
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthServiceImpl(
    private val authenticationManager: AuthenticationManager,
    private val jwtTokenProvider: JwtTokenProvider,
    private val userRepository: UserRepository,
    private val passwordEncoder: BCryptPasswordEncoder,
): AuthService {

    override fun login(email: String, password: String): String {
        val authentication = authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(email, password)
        )
        SecurityContextHolder.getContext().authentication = authentication
        return jwtTokenProvider.generateAccessToken(authentication)
    }

    override fun signup(email: String, password: String): String {
        val existUser = userRepository.findByEmail(email)
        if (existUser != null) {
            throw Exception("이미 존재하는 사용자입니다.")
        }
        // bcrypt 암호화
        val encodedPassword = passwordEncoder.encode(password)
        val user = userRepository.save(User(email = email, password = encodedPassword))
        return jwtTokenProvider.generateAccessToken(UsernamePasswordAuthenticationToken(SecurityUser(user), null))
    }
}