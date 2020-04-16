package com.epiuse.labs.training.sekret.anonymizer

import org.springframework.stereotype.Component

@Component
class LastNameAnonymizer: Anonymizer<String, String> {

    override fun anonymize(input: String): String {
        return "Smith"
    }
}