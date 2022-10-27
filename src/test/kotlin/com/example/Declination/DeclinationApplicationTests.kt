package com.example.Declination

import org.hamcrest.core.StringContains.containsString
import com.example.Declination.service.WordDeclinationService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
class DeclinationApplicationTests {

    private val baseUri = "http://localhost:8080/spell"
    private val testWordsList = listOf("кот", "кота", "коту", "кота", "котом", "коте")
    private val testWordsString = "[\"кот\",\"кота\",\"коту\",\"кота\",\"котом\",\"коте\"]"


    @Autowired
    private lateinit var wordDeclinationService: WordDeclinationService

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun serviceTest() {
        assertEquals(wordDeclinationService.spell("кот"), testWordsList)
    }

    @Test
    fun restApiTest() {
        mockMvc.perform(get("$baseUri/кот")).andExpect(content().string(containsString(testWordsString)))
    }
}

