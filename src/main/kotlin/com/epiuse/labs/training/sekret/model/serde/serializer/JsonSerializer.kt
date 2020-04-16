package com.epiuse.labs.training.sekret.model.serde.serializer

import com.google.gson.Gson
import org.apache.kafka.common.serialization.Serializer

class JsonSerializer<T> : Serializer<T> {

    private val gson = Gson()

    @ExperimentalStdlibApi
    override fun serialize(topic: String?, data: T): ByteArray = gson.toJson(data).encodeToByteArray()
}
