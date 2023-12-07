package com.ticket.dbsulticketsystem.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.ticket.dbsulticketsystem.jwt.JwtAuthenticationFilter
import com.ticket.dbsulticketsystem.jwt.JwtAuthenticationProvider
import com.ticket.dbsulticketsystem.jwt.JwtExceptionFilter
import com.ticket.dbsulticketsystem.jwt.JwtTokenProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val objectMapper: ObjectMapper,
    private val userDetailsService: UserDetailsService,
    private val jwtAuthenticationProvider: JwtAuthenticationProvider,
) {

    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.httpBasic().disable()
            .authorizeRequests()
            .antMatchers("/auth/signup").permitAll()
            .antMatchers("/auth/login").permitAll()
            .and()
            .addFilterBefore(
                JwtAuthenticationFilter(
                    authenticationManager(http),
                ),
                UsernamePasswordAuthenticationFilter::class.java
            )
            .addFilterBefore(JwtExceptionFilter(objectMapper), JwtAuthenticationFilter::class.java)
            .csrf().disable()

        return http.build()
    }

    @Bean
    fun authenticationManager(http: HttpSecurity): AuthenticationManager {
        val authManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder::class.java)
        authManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder())
            .and()
            .authenticationProvider(jwtAuthenticationProvider)
        return authManagerBuilder.build()
    }

    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()
}
