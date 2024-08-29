package com.github.cpmachado.testing_spring_boot_rest_api_using_testcontainers

import com.github.cpmachado.testing_spring_boot_rest_api_using_testcontainers.entity.Customer
import com.github.cpmachado.testing_spring_boot_rest_api_using_testcontainers.repository.CustomerRepository
import io.restassured.RestAssured
import io.restassured.RestAssured.*
import io.restassured.http.ContentType
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import kotlin.test.Test

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerTest(
    @LocalServerPort val port: Int,
    @Autowired val customerRepository: CustomerRepository,
) {
    companion object {
        @JvmStatic
        val postgreSQLContainer = PostgreSQLContainer("postgres:16-alpine")

        @JvmStatic
        @BeforeAll
        fun beforeAll(): Unit {
            postgreSQLContainer.start()
        }

        @JvmStatic
        @AfterAll
        fun afterAll(): Unit {
            postgreSQLContainer.stop()
        }

        @JvmStatic
        @DynamicPropertySource
        fun configureProperties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url") { postgreSQLContainer.jdbcUrl }
            registry.add("spring.datasource.username") { postgreSQLContainer.getUsername() }
            registry.add("spring.datasource.password") { postgreSQLContainer.getPassword() }
        }
    }

    @BeforeEach
    fun setUp() {
        RestAssured.baseURI = "http://localhost:$port"
        customerRepository.deleteAll()
    }

    @Test
    fun shouldGetAllCustomers() {
        val customers = listOf(
            Customer(0, "John", "john@mail.com"),
            Customer(0, "Dennis", "dennis@mail.com"),
        )
        customerRepository.saveAll(customers)
        given().contentType(ContentType.JSON).`when`().get("/api/customers").then().statusCode(200).body(".", hasSize<Customer>(2))
    }
}