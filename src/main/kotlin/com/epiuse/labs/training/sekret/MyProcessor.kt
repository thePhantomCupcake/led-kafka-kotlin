package com.epiuse.labs.training.sekret

import org.springframework.cloud.stream.annotation.Input
import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.SubscribableChannel


interface MyProcessor {

    @Input(INPUT)
    fun input(): SubscribableChannel?

    @Output(OUTPUT)
    fun output(): MessageChannel?

    companion object {
        const val OUTPUT = "my-processor-out"
        const val INPUT = "my-processor-in"
    }
}
