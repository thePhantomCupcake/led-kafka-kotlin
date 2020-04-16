package com.epiuse.labs.training.sekret.anonymizer

import com.github.javafaker.*
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class FirstNameAnonymizer : Anonymizer<String, String> {

    private val faker = Faker()

    private val firstNames = ConcurrentHashMap<String, String>()

    override fun anonymize(input: String): String {
        return if (firstNames.containsKey(input)) {
            firstNames[input]!!
        } else {
            val newName = faker.name().firstName()
            firstNames[input] = newName
            newName!!
        }
    }

}