package com.epiuse.labs.training.sekret

import com.epiuse.labs.training.sekret.model.User
import org.slf4j.LoggerFactory
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Sink

@EnableBinding(Sink::class)
class AnonymizedConsumer {

    @StreamListener(Sink.INPUT)
    fun consume(value: User) {
        LOGGER.info("Successfully anonymized user with result: $value")
    }

    companion object {
        val LOGGER = LoggerFactory.getLogger(AnonymizedConsumer::class.java)
    }
}