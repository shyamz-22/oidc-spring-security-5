package com.github.shyamz22.oidcspringsecurity5

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    companion object {
        val log: Logger = LoggerFactory.getLogger(HelloController::class.java)
    }

    @GetMapping("/me")
    fun hello(): ResponseEntity<String> {
        return ResponseEntity.ok("ok")
    }

}