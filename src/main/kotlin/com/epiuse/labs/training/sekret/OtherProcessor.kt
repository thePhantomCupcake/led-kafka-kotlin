package com.epiuse.labs.training.sekret

import com.epiuse.labs.training.sekret.anonymizer.UserAnonymizerService
import com.epiuse.labs.training.sekret.binding.MyOtherProcessor
import com.epiuse.labs.training.sekret.model.User
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Processor
import org.springframework.messaging.handler.annotation.SendTo

@EnableBinding(MyOtherProcessor::class)
class OtherProcessor @Autowired constructor(
        val userAnonymizerService: UserAnonymizerService
) {

    @StreamListener(MyOtherProcessor.INPUT)
    @SendTo(MyOtherProcessor.OUTPUT)
    fun process(value: User): User {
        LOGGER.info("OP: Processing user: $value")
        return userAnonymizerService.process(value)
    }

    companion object {
        val LOGGER = LoggerFactory.getLogger(Processor::class.java)
    }
}