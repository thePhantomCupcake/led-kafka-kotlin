package com.epiuse.labs.training.sekret

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.integration.config.EnableIntegration

@EnableIntegration
@SpringBootApplication
class SekretApplication

fun main(args: Array<String>) {
	runApplication<SekretApplication>(*args)
}
