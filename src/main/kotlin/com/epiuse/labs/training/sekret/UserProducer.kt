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

class UserProducer {

    private val faker = Faker()

    //TODO: implement producer to push a random user every 2 seconds to the production topic

    companion object {

        var x = 0L
    }
}