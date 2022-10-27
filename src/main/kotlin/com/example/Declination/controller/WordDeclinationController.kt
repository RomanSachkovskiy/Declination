package com.example.Declination.controller

import com.example.Declination.service.WordDeclinationService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/spell")
class WordDeclinationController(
    private val WordCase: WordDeclinationService
) {

    @GetMapping("{word}", produces = ["application/json;charset=UTF-8"])
    @ResponseStatus(HttpStatus.OK)
    fun declination(@PathVariable word: String): List<String> = WordCase.spell(word)

}