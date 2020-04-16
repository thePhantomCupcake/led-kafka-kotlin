package com.epiuse.labs.training.sekret.anonymizer

import com.epiuse.labs.training.sekret.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserAnonymizerService @Autowired constructor(
        private val firstNameAnonymizer: FirstNameAnonymizer,
        private val lastNameAnonymizer: LastNameAnonymizer,
        private val emailAddressAnonymizer: EmailAddressAnonymizer
) {

    var pipeline: AnonymizerPipeline<User> = AnonymizerPipeline()

    fun process(user: User): User = pipeline.addSteps(
            {
                it.firstName = firstNameAnonymizer.anonymize(it.firstName)
                it
            },
            {
                it.lastName = lastNameAnonymizer.anonymize(it.lastName)
                it
            }
    ).addStep {
        it.emailAddress = emailAddressAnonymizer.anonymize(it.firstName to it.lastName)
        it
    }
            .execute(user)
}