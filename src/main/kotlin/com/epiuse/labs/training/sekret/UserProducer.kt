package com.epiuse.labs.training.sekret

import com.epiuse.labs.training.sekret.binding.MyProducer
import com.epiuse.labs.training.sekret.model.User
import com.github.javafaker.*
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.integration.annotation.InboundChannelAdapter
import org.springframework.integration.annotation.Poller
import org.springframework.messaging.Message
import org.springframework.messaging.MessageHeaders.CONTENT_TYPE
import org.springframework.messaging.support.MessageBuilder
import org.springframework.util.MimeTypeUtils.APPLICATION_JSON

@EnableBinding(MyProducer::class)
class UserProducer {

    private val faker = Faker()

    @InboundChannelAdapter(channel = MyProducer.OUTPUT, poller = [Poller(fixedRate = "1000")])
    fun generate(): Message<*>? {
        val firstName = faker.name().firstName()
        val lastName = faker.name().lastName()
        val emailAddress = "${firstName[0]}${lastName}@labs.com".toLowerCase()

        val value = User(++x, firstName, lastName, emailAddress)
        println("Sending: $value")
        return MessageBuilder.withPayload(value)
                .setHeader(CONTENT_TYPE, APPLICATION_JSON)
                .setHeader("partitionKey", value)
                .build()
    }

    companion object {
        var x = 0L
    }
}