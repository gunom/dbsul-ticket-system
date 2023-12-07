package com.ticket.dbsulticketsystem.jwt

import com.ticket.dbsulticketsystem.domain.SecurityUser
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.security.Key

@Component
class JwtTokenProvider(
    @Value("\${jwt.secret}")
    private val jwtAccessSecret: String?,
    @Value("\${jwt.access-expires-in}")
    private val accessExpiresIn: Long = 3600,
) {
    fun getClaimAndKey(
        userPk: Int,
        username: String,
        tokenSecretKey: String?,
    ): Pair<Claims, Key?> {
        val claims = Jwts.claims()
        claims["id"] = userPk
        claims["username"] = username
        val key = Keys.hmacShaKeyFor(tokenSecretKey?.toByteArray()?.copyOf(64))
        return Pair(claims, key)
    }

    fun generateAccessToken(authentication: Authentication): String {
        val userPrincipal = authentication.principal as SecurityUser
        val userPk = userPrincipal.getId()
        val username = userPrincipal.getUsername()
        val (claims, key) = getClaimAndKey(userPk, username, jwtAccessSecret)
        return JwtUtil(this.jwtAccessSecret).encodeAccessToken(claims, key, accessExpiresIn)
    }

    fun getUsername(accessToken: String): String {
        val claims = JwtUtil(this.jwtAccessSecret).decodeToken(accessToken)
        return (claims?.getValue("username") ?: "").toString()
    }

}