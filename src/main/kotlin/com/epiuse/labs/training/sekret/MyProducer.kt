package com.epiuse.labs.training.sekret

import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.MessageChannel


interface MyProducer {

    @Output(OUTPUT)
    fun output(): MessageChannel?

    companion object {
        const val OUTPUT = "my-producer-out"
    }
}
