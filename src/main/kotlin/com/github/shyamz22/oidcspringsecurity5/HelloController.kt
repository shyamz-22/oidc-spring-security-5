package com.github.shyamz22.oidcspringsecurity5

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    companion object {
        val log: Logger = LoggerFactory.getLogger(HelloController::class.java)
    }

    @GetMapping("/me")
    fun hello(currentUser: OAuth2AuthenticationToken): ResponseEntity<OAuth2AuthenticationToken> {
        log.warn("User authentication successful")
        return ResponseEntity.ok(currentUser)
    }

}