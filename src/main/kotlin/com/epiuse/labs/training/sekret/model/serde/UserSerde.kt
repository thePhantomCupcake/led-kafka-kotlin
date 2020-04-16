package com.epiuse.labs.training.sekret.model.serde

import com.epiuse.labs.training.sekret.model.User
import com.epiuse.labs.training.sekret.model.serde.deserializer.JsonDeserializer
import com.epiuse.labs.training.sekret.model.serde.serializer.JsonSerializer
import org.apache.kafka.common.serialization.Deserializer
import org.apache.kafka.common.serialization.Serde
import org.apache.kafka.common.serialization.Serializer

class UserSerde: Serde<User> {

    override fun deserializer(): Deserializer<User> {
        return JsonDeserializer()
    }

    override fun serializer(): Serializer<User> {
        return JsonSerializer()
    }
}