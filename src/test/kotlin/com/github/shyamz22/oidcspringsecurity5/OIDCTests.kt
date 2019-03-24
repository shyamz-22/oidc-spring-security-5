package com.github.shyamz22.oidcspringsecurity5

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*


@RunWith(SpringRunner::class)
@SpringBootTest
@ActiveProfiles("local")
@AutoConfigureMockMvc
class OIDCTests {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun unAuthenticatedRequestIsRedirectedToIdentityProvider() {

        mockMvc.perform(get("/"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isFound)
                .andExpect(redirectedUrlPattern("**/oauth2/authorization/google"))
    }
}