package com.epiuse.labs.training.sekret.model.serde.deserializer

import com.google.gson.Gson
import org.apache.kafka.common.serialization.Deserializer

class JsonDeserializer<T> : Deserializer<T> {

    private val gson = Gson()

    private var deserializedClass: Class<T>? = null

    override fun configure(map: Map<String?, *>, b: Boolean) {
        if (deserializedClass == null) {
            deserializedClass = map["serializedClass"] as Class<T>?
        }
    }

    @ExperimentalStdlibApi
    override fun deserialize(topic: String?, data: ByteArray): T {
        return gson.fromJson(data.decodeToString(), deserializedClass)
    }

}