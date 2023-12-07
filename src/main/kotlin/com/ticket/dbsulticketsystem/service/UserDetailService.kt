package com.ticket.dbsulticketsystem.service

import com.ticket.dbsulticketsystem.domain.SecurityUser
import com.ticket.dbsulticketsystem.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
@Service
class UserDetailService(
    private val userRepository: UserRepository
) : UserDetailsService {
    override fun loadUserByUsername(email: String): UserDetails {
        val user = userRepository.findByEmail(email) ?: throw Exception("존재하지 않는 사용자입니다.")
        return SecurityUser(user)
    }
}