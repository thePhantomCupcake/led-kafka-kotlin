package com.epiuse.labs.training.sekret

import com.epiuse.labs.training.sekret.anonymizer.UserAnonymizerService
import com.epiuse.labs.training.sekret.model.User
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Processor
import org.springframework.messaging.handler.annotation.SendTo

class Processor {

    // TODO: implement processor to anonymize incoming users and publish to "anonymous" topic

    companion object {
        val LOGGER = LoggerFactory.getLogger(Processor::class.java)
    }
}