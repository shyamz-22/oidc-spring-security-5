package com.github.shyamz22.oidcspringsecurity5

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class OIDCTests {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun unAuthenticatedRequestIsRedirectedToIdentityProvider() {

        mockMvc.perform(get("/"))
                .andExpect(status().isFound)
                .andExpect(redirectedUrlPattern("https://accounts.google.com/o/oauth2/v2/auth/**"))
    }
}