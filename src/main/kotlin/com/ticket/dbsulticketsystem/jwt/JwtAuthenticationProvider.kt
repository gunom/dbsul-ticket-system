package com.ticket.dbsulticketsystem.jwt

import com.ticket.dbsulticketsystem.domain.SecurityUser
import com.ticket.dbsulticketsystem.repository.UserRepository
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import java.security.Key

@Component
class JwtAuthenticationProvider(
    @Value("\${jwt.secret}")
    private val jwtAccessSecret: String?,
    private val userRepository: UserRepository,
    private val userDetailsService: UserDetailsService,
    // alpha:(3600 * 24) 그 외: 3600
    @Value("\${jwt.access-expires-in}")
    private val accessExpiresIn: Long = 3600,
) : AuthenticationProvider {

    override fun authenticate(authentication: Authentication?): Authentication? {
        val jwtToken = (authentication as JwtAuthenticationToken).jsonWebToken
        if (!jwtToken.isNullOrEmpty()) {
            val claims = JwtUtil(jwtAccessSecret).decodeToken(jwtToken)
            val userDetails = userDetailsService.loadUserByUsername(claims?.get("username").toString()) as SecurityUser
            return JwtAuthenticationToken(
                principal = userDetails,
                credentials = userDetails.password,
                userDetails = userDetails,
            )
        }
        return null
    }

    override fun supports(authentication: Class<*>?): Boolean {
        return JwtAuthenticationToken::class.java.isAssignableFrom(authentication)
    }

    fun getClaimAndKey(
        userPk: Int,
        tokenSecretKey: String?
    ): Pair<Claims, Key?> {
        val claims = Jwts.claims()
        claims["id"] = userPk
        val key = Keys.hmacShaKeyFor(tokenSecretKey?.toByteArray()?.copyOf(64))
        return Pair(claims, key)
    }

    fun generateAccessToken(userPk: Int): String {
        val (claims, key) = getClaimAndKey(userPk, jwtAccessSecret)
        return JwtUtil(this.jwtAccessSecret).encodeAccessToken(claims, key, accessExpiresIn)
    }
}