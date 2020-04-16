package com.epiuse.labs.training.sekret.anonymizer

import org.springframework.stereotype.Component

@Component
class EmailAddressAnonymizer: Anonymizer<Pair<String, String>, String> {

    override fun anonymize(input: Pair<String, String>): String {
        return  "${input.first}${input.second}${emailProviders.random()}"
    }

    companion object {
        val emailProviders = listOf("@gmail.com", "@yahoo.com", "msn.com", "@random.org")
    }

}