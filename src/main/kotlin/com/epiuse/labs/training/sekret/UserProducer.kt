package com.epiuse.labs.training.sekret

import com.epiuse.labs.training.sekret.model.User
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.integration.annotation.InboundChannelAdapter
import org.springframework.integration.annotation.Poller
import org.springframework.messaging.Message
import org.springframework.messaging.MessageHeaders.CONTENT_TYPE
import org.springframework.messaging.support.MessageBuilder
import org.springframework.util.MimeTypeUtils.APPLICATION_JSON

import com.github.javafaker.*
import com.epiuse.labs.training.sekret.binding.MyProducer

@EnableBinding(MyProducer::class)
class UserProducer {

    @InboundChannelAdapter(channel = MyProducer.OUTPUT, poller = [Poller(fixedRate = "1000")])
    fun generate(): Message<*>? {
        val value = User(++x, "James", "Brown", "jbrown@labs.co.za")
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