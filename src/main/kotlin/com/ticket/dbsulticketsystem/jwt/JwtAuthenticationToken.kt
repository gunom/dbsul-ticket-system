package com.ticket.dbsulticketsystem.jwt

import com.ticket.dbsulticketsystem.domain.SecurityUser
import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails

class JwtAuthenticationToken : AbstractAuthenticationToken {
    var jsonWebToken: String? = null
    private var principal: UserDetails?
    private var credentials: String?
    private var details: UserDetails? = null

    constructor(jsonWebToken: String?) : super(null) {
        this.jsonWebToken = jsonWebToken
        this.principal = null
        this.credentials = null
        this.isAuthenticated = false
    }

    // authorities는 개발 필요에 따라 추가.
    constructor(principal: UserDetails?, credentials: String?, userDetails: SecurityUser?) : super(
            null
    ) {
        this.principal = principal
        this.credentials = credentials
        this.details = userDetails
        this.isAuthenticated = true
    }


    override fun getCredentials(): String? {
        return credentials
    }

    override fun getPrincipal(): UserDetails? {
        return principal
    }

    override fun getDetails(): UserDetails? {
        return details
    }
}