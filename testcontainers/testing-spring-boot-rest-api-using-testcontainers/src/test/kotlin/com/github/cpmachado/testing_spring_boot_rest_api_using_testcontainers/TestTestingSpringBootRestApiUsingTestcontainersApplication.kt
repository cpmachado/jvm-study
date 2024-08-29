package com.github.cpmachado.testing_spring_boot_rest_api_using_testcontainers

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
	fromApplication<TestingSpringBootRestApiUsingTestcontainersApplication>().with(TestcontainersConfiguration::class).run(*args)
}
