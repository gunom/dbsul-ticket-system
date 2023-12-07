package com.ticket.dbsulticketsystem.jwt

import com.ticket.dbsulticketsystem.domain.SecurityUser
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtAuthenticationFilter(
    private val authenticationManager: AuthenticationManager,
) : OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {
        val accessToken = request.getHeader("Authorization")?.substring(7) // remove 'Bearer '
        if (!accessToken.isNullOrBlank()) {
            // 인증되지않은 Authentication 객체 생성
            val jwtAuthenticationToken = JwtAuthenticationToken(accessToken)
            // provider를 통해 authentication 진행
            val authentication = this.authenticationManager.authenticate(jwtAuthenticationToken)
            SecurityContextHolder.getContext().authentication = authentication
        }

        chain.doFilter(request, response)
    }
}