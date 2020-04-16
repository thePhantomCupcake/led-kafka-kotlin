package com.epiuse.labs.training.sekret

import com.epiuse.labs.training.sekret.model.User
import org.apache.kafka.streams.kstream.KStream
import org.slf4j.LoggerFactory
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Sink

class AnonymizedConsumer {

    //TODO: implement consumer using default Sink binding to read from "anonymous" topic

    companion object {
        val LOGGER = LoggerFactory.getLogger(AnonymizedConsumer::class.java)
    }
}