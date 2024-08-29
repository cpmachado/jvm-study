package com.github.cpmachado.testing_spring_boot_rest_api_using_testcontainers.rest

import com.github.cpmachado.testing_spring_boot_rest_api_using_testcontainers.repository.CustomerRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class CustomerController(
    private val repository: CustomerRepository
) {
    @GetMapping("/customers")
    fun getAll() = repository.findAll()
}