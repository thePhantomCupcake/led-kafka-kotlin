package com.epiuse.labs.training.sekret.binding

import org.springframework.cloud.stream.annotation.Input
import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.SubscribableChannel


interface MyOtherProcessor {

    @Input(INPUT)
    fun input(): SubscribableChannel

    @Output(OUTPUT)
    fun output(): MessageChannel?

    companion object {
        const val INPUT = "my-other-processor-in"
        const val OUTPUT = "my-other-processor-out"
    }
}
