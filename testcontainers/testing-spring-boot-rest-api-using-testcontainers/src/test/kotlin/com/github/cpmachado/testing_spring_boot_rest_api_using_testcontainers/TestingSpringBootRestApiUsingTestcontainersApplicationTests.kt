package com.github.cpmachado.testing_spring_boot_rest_api_using_testcontainers

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import

@Import(TestcontainersConfiguration::class)
@SpringBootTest
class TestingSpringBootRestApiUsingTestcontainersApplicationTests {

	@Test
	fun contextLoads() {
	}

}
