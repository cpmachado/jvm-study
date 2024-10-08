package com.github.cpmachado.testing_spring_boot_rest_api_using_testcontainers.repository

import com.github.cpmachado.testing_spring_boot_rest_api_using_testcontainers.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository: JpaRepository<Customer, Long>